package com.apps.fullcourseandroidclassb.otherapps.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.onboardingscreen.model.OnBoardingScreensItem
import com.apps.fullcourseandroidclassb.databinding.OnboardingScreensItemBinding

class OnBoardingScreenItemAdapter(private val onBoardingScreenItem: List<OnBoardingScreensItem>) :
    RecyclerView.Adapter<OnBoardingScreenItemAdapter.OnBoardingScreenItemViewHolder>() {
    inner class OnBoardingScreenItemViewHolder(val binding: OnboardingScreensItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val ivOnBoardingScreenItemImage =
            itemView.findViewById<ImageView>(R.id.ivOnBoardingItemImage)
        private val tvOnBoardingItemTitle =
            itemView.findViewById<TextView>(R.id.tvOnBoardingItemTitle)
        private val tvOnBoardingItemDescription =
            itemView.findViewById<TextView>(R.id.tvOnBoardingItemDescription)

        fun bind(onBoardingScreensItem: OnBoardingScreensItem) {
            binding.ivOnBoardingItemImage.setImageResource(onBoardingScreensItem.onBoardingScreenItemImage)
            binding.tvOnBoardingItemTitle.text = onBoardingScreensItem.onBoardingScreenItemTitle
            binding.tvOnBoardingItemDescription.text =
                onBoardingScreensItem.onBoardingScreenItemDescription
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardingScreenItemViewHolder {
        return OnBoardingScreenItemViewHolder(
            OnboardingScreensItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingScreenItemViewHolder, position: Int) {
        holder.bind(onBoardingScreenItem[position])

    }

    override fun getItemCount(): Int {
        return onBoardingScreenItem.size
    }
}