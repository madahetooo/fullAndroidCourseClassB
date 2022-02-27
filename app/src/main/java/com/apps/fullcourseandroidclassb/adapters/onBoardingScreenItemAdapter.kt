package com.apps.fullcourseandroidclassb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.data.local.db.entities.OnBoardingScreensItem

class OnBoardingScreenItemAdapter(private val onBoardingScreenItem: List<OnBoardingScreensItem>) :
    RecyclerView.Adapter<OnBoardingScreenItemAdapter.OnBoardingScreenItemViewHolder>() {
    inner class OnBoardingScreenItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivOnBoardingScreenItemImage =
            itemView.findViewById<ImageView>(R.id.ivOnBoardingItemImage)
        private val tvOnBoardingItemTitle =
            itemView.findViewById<TextView>(R.id.tvOnBoardingItemTitle)
        private val tvOnBoardingItemDescription =
            itemView.findViewById<TextView>(R.id.tvOnBoardingItemDescription)

        fun bind(onBoardingScreensItem: OnBoardingScreensItem) {
            ivOnBoardingScreenItemImage.setImageResource(onBoardingScreensItem.onBoardingScreenItemImage)
            tvOnBoardingItemTitle.text = onBoardingScreensItem.onBoardingScreenItemTitle
            tvOnBoardingItemDescription.text = onBoardingScreensItem.onBoardingScreenItemDescription
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardingScreenItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.onboarding_screens_item, parent, false)
        return OnBoardingScreenItemViewHolder(view)

    }

    override fun onBindViewHolder(holder: OnBoardingScreenItemViewHolder, position: Int) {
        holder.bind(onBoardingScreenItem[position])

    }

    override fun getItemCount(): Int {
        return onBoardingScreenItem.size
    }
}