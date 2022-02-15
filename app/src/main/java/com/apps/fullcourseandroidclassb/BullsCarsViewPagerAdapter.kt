package com.apps.fullcourseandroidclassb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bulls_cars_view_pager.view.*
import kotlinx.android.synthetic.main.item_todo.view.*

class BullsCarsViewPagerAdapter(var images:List<Int>) : RecyclerView.Adapter<BullsCarsViewPagerAdapter.BullsCarsViewPagerViewHolder>() {
    inner class BullsCarsViewPagerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BullsCarsViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bulls_cars_view_pager,parent,false)
        return BullsCarsViewPagerViewHolder(view)

    }

    override fun onBindViewHolder(holder: BullsCarsViewPagerViewHolder, position: Int) {
        val currentBullsCarsImage = images[position]
        holder.itemView.ivBullsCarsImage.setImageResource(currentBullsCarsImage)


    }

    override fun getItemCount(): Int {
        return  images.size
    }
}