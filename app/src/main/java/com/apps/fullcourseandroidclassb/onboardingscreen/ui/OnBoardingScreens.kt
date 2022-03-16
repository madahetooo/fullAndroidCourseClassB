package com.apps.fullcourseandroidclassb.onboardingscreen.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ActivityOnboardingScreensBinding
import com.apps.fullcourseandroidclassb.otherapps.adapters.OnBoardingScreenItemAdapter
import com.apps.fullcourseandroidclassb.onboardingscreen.model.OnBoardingScreensItem

class OnBoardingScreens : AppCompatActivity() {
    private lateinit var binding:ActivityOnboardingScreensBinding
    private lateinit var onBoardingScreenItemAdapter: OnBoardingScreenItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingScreensBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupOnBoardingScreenItem()
    }

    private fun setupOnBoardingScreenItem() {
        onBoardingScreenItemAdapter = OnBoardingScreenItemAdapter(
            listOf(
                OnBoardingScreensItem(
                    onBoardingScreenItemImage = R.drawable.onboardingone,
                    onBoardingScreenItemTitle = "PAY ONCE",
                    onBoardingScreenItemDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                ),
                OnBoardingScreensItem(
                    onBoardingScreenItemImage = R.drawable.onboardingtwo,
                    onBoardingScreenItemTitle = "FREE UI UX Template",
                    onBoardingScreenItemDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                ),
                OnBoardingScreensItem(
                    onBoardingScreenItemImage = R.drawable.onboardingone,
                    onBoardingScreenItemTitle = "ALL IN ONE",
                    onBoardingScreenItemDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                ),
            )
        )
        binding.onBoardingScreensViewPager.adapter = onBoardingScreenItemAdapter
    }
}