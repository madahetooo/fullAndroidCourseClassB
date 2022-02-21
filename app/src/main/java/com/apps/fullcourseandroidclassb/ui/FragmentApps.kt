package com.apps.fullcourseandroidclassb.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.FragmentAppsBinding
import kotlinx.android.synthetic.main.fragment_apps.*

class FragmentApps :Fragment(R.layout.fragment_apps) {

    private lateinit var binding: FragmentAppsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAppsBinding.bind(view)
        binding.tvAppsFragment.setText("NEW APPS FRAGMENT WITH BINDING")
    }
}