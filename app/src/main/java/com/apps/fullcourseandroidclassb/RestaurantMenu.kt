package com.apps.fullcourseandroidclassb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_resturant_menu.*
import kotlinx.android.synthetic.main.activity_resturant_menu.view.*

class RestaurantMenu : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_resturant_menu, container, false)
        view.btnOrder.setOnClickListener {
            val checkedRadioButtonId = view.rgBurgers.checkedRadioButtonId
            val burgersDetails = view.findViewById<RadioButton>(checkedRadioButtonId)
            val cheese = view.cbCheese.isChecked
            val onions = view.cbOnions.isChecked
            val salad = view.cbSalad.isChecked
            if (burgersDetails != null) {
                val totalOrder = "You Order a burger with \n" +
                        "${burgersDetails.text}" +
                        (if (cheese) "\nCheese" else "") +
                        (if (onions) "\nOnions" else "") +
                        (if (salad) "\nSalad" else "")
                view.tvTotalOrder.text = totalOrder
            }
        }
        return view
    }
}