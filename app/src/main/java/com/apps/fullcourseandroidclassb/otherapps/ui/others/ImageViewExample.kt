package com.apps.fullcourseandroidclassb.otherapps.ui.others

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ActivityImageViewExampleBinding

class ImageViewExample : Fragment() {
    private var _binding: ActivityImageViewExampleBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityImageViewExampleBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

}