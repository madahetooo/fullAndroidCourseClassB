package com.apps.fullcourseandroidclassb.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.adapters.OnBoardingScreenItemAdapter
import com.apps.fullcourseandroidclassb.data.local.db.entities.OnBoardingScreensItem
import kotlinx.android.synthetic.main.activity_onboarding_screens.*

class OnBoardingScreens : AppCompatActivity() {
    private lateinit var onBoardingScreenItemAdapter: OnBoardingScreenItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_screens)
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
        onBoardingScreensViewPager.adapter = onBoardingScreenItemAdapter
    }
}