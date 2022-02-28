package com.apps.fullcourseandroidclassb.ui.base

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullcourseandroidclassb.R

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()


        Handler().postDelayed({
            val intent = Intent(this, OnBoardingScreens::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}