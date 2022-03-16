package com.apps.fullcourseandroidclassb.otherapps.ui.others

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ActivityResturantMenuBinding

class RestaurantMenu : Fragment() {
    private var _binding: ActivityResturantMenuBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityResturantMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btnOrder.setOnClickListener {
            val checkedRadioButtonId = binding.rgBurgers.checkedRadioButtonId
            val burgersDetails = view.findViewById<RadioButton>(checkedRadioButtonId)
            val cheese = binding.cbCheese.isChecked
            val onions = binding.cbOnions.isChecked
            val salad = binding.cbSalad.isChecked
            if (burgersDetails != null) {
                val totalOrder = "You Order a burger with \n" +
                        "${burgersDetails.text}" +
                        (if (cheese) "\nCheese" else "") +
                        (if (onions) "\nOnions" else "") +
                        (if (salad) "\nSalad" else "")
                binding.tvTotalOrder.text = totalOrder
            }
        }
        return view
    }
}