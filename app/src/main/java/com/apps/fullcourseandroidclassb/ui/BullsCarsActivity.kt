package com.apps.fullcourseandroidclassb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.adapters.BullsCarsViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_bulls_cars.view.*

class BullsCarsActivity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_bulls_cars, container, false)
        val viewPagger = view.findViewById<ViewPager2>(R.id.bullsCarsViewPager)
        val tabLayout = view.findViewById<TabLayout>(R.id.bullsCarsTabLaout)
        val listOfImages = listOf(
            R.drawable.bulls_car_logo,
            R.drawable.bulls_cars_logo_new,
            R.drawable.car_logos1,
            R.drawable.cars_logos2,
            R.drawable.carslogos3,
            R.drawable.carslogos4,
            R.drawable.carslogos5,
            R.drawable.carslogos6,
        )
        val bullsCarsAdapter = BullsCarsViewPagerAdapter(listOfImages)
        view.bullsCarsViewPager.adapter = bullsCarsAdapter

        TabLayoutMediator(tabLayout, viewPagger) { tab, position ->
            tab.text = "tab${position + 1}"
        }.attach()

        view.bullsCarsTabLaout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(activity, "Selected ${tab?.text}", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    activity,
                    "UnSelected ${tab?.text}",
                    Toast.LENGTH_SHORT
                ).show()

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    activity,
                    "ReSelected ${tab?.text}",
                    Toast.LENGTH_SHORT
                ).show()

            }

        })
        return view
    }
}

//        bullsCarsViewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
//        bullsCarsViewPager.beginFakeDrag()
//        bullsCarsViewPager.fakeDragBy(-10f)
//        bullsCarsViewPager.endFakeDrag()

