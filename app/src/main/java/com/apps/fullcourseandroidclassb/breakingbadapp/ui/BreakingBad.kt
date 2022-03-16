package com.apps.fullcourseandroidclassb.breakingbadapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ActivityBreakingBadBinding

class BreakingBad : AppCompatActivity() {
    private lateinit var binding: ActivityBreakingBadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreakingBadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}