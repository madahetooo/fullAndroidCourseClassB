package com.apps.fullcourseandroidclassb

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_bulls_cars.*

class BullsCarsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bulls_cars)

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
        bullsCarsViewPager.adapter = bullsCarsAdapter

        TabLayoutMediator(bullsCarsTabLaout,bullsCarsViewPager){tab,position ->
            tab.text = "tab${position + 1}"
        }.attach()

        bullsCarsTabLaout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@BullsCarsActivity,"Selected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@BullsCarsActivity,"UnSelected ${tab?.text}",Toast.LENGTH_SHORT).show()

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@BullsCarsActivity,"ReSelected ${tab?.text}",Toast.LENGTH_SHORT).show()

            }

        })






//        bullsCarsViewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
//        bullsCarsViewPager.beginFakeDrag()
//        bullsCarsViewPager.fakeDragBy(-10f)
//        bullsCarsViewPager.endFakeDrag()

    }
}