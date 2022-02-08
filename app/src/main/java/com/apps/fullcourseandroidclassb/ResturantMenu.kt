package com.apps.fullcourseandroidclassb

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_resturant_menu.*

class ResturantMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resturant_menu)
        btnOrder.setOnClickListener {
            val checkedRadioButtonId = rgBurgers.checkedRadioButtonId
            val burgersDetails = findViewById<RadioButton>(checkedRadioButtonId)
            val cheese = cbCheese.isChecked
            val onions = cbOnions.isChecked
            val salad = cbSalad.isChecked
            if (burgersDetails!=null){
                val totalOrder = "You Order a burger with \n"+
                        "${burgersDetails.text}"+
                        (if (cheese)"\nCheese" else "")+
                        (if (onions)"\nOnions" else "")+
                        (if (salad)"\nSalad" else "")
                tvTotalOrder.text = totalOrder
            }




        }
    }
}