package com.apps.fullcourseandroidclassb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullcourseandroidclassb.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.clothes_item.view.*

class ClothesImagesAdapter(var urls :List<String>)  : RecyclerView.Adapter<ClothesImagesAdapter.ClothesImagesViewHolder>(){
    inner class ClothesImagesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesImagesViewHolder {
        return ClothesImagesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.clothes_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ClothesImagesViewHolder, position: Int) {
    val url = urls[position]
        Glide.with(holder.itemView).load(url).into(holder.itemView.ivClothesImageItem)
    }

    override fun getItemCount(): Int {
        return urls.size
    }

}