package com.apps.fullcourseandroidclassb.ui.others

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import kotlinx.android.synthetic.main.activity_counter.view.*

class Counter : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_counter, container, false)
        var count = 0
        view.btnCount.setOnClickListener {
            count++
            view.tvCount.text = "Lets Count Together $count"

        }
        return view
    }
}