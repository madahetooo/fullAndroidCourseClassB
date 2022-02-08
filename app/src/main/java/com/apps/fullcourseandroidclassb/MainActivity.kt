package com.apps.fullcourseandroidclassb

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_taost.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnApply.setOnClickListener {
//            val firstName = etFirstName.text.toString()
//            val lastName = etLastName.text.toString()
//            val birthDate = etBirthDate.text.toString()
//            val country = etCountry.text.toString()
//            Toast.makeText(this, "Hello $firstName $lastName," +
//                    " you born in $birthDate, in $country"
//                    ,Toast.LENGTH_LONG).show()
//
//            intent = Intent(this,ResturantMenu::class.java)
//            startActivity(intent)

            Toast(this).apply {
               duration = Toast.LENGTH_LONG
                view = layoutInflater.inflate(R.layout.custom_taost,clToast)
                show()
            }
        }

    }
}