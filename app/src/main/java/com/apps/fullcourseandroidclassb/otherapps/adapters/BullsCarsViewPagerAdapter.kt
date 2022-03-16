package com.apps.fullcourseandroidclassb.otherapps.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ItemBullsCarsViewPagerBinding

class BullsCarsViewPagerAdapter(var images:List<Int>) : RecyclerView.Adapter<BullsCarsViewPagerAdapter.BullsCarsViewPagerViewHolder>() {
    inner class BullsCarsViewPagerViewHolder(val binding: ItemBullsCarsViewPagerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BullsCarsViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bulls_cars_view_pager,parent,false)
        return BullsCarsViewPagerViewHolder(ItemBullsCarsViewPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: BullsCarsViewPagerViewHolder, position: Int) {
        val currentBullsCarsImage = images[position]
        holder.binding.ivBullsCarsImage.setImageResource(currentBullsCarsImage)
    }

    override fun getItemCount(): Int {
        return  images.size
    }
}