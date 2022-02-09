package com.apps.fullcourseandroidclassb

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    var pressTwiceToExit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnApply.setOnClickListener {
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val birthDate = etBirthDate.text.toString()
            val country = etCountry.text.toString()
            Toast.makeText(
                this, "Hello $firstName $lastName," +
                        " you born in $birthDate, in $country", Toast.LENGTH_LONG
            ).show()

            intent = Intent(this, ResturantMenu::class.java)
            startActivity(intent)
//
//            Toast(this).apply {
//               duration = Toast.LENGTH_LONG
//                view = layoutInflater.inflate(R.layout.custom_taost,clToast)
//                show()
//            }
        }

        val namesList = listOf("Mustapha", "Osama", "Imen", "Rayen", "Chiraz", "Amel", "Eslam")
        val namesAdapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,namesList)
        spMonths.adapter = namesAdapter
            spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        "You selected ${parent!!.getItemAtPosition(position).toString()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }


                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }
    }


    override fun onBackPressed() {
        if (pressTwiceToExit) { // current value is TRUE
            finish() // when it is TRUE, Close the application
            super.onBackPressed()
        }
        pressTwiceToExit = true // Reassign to be TRUE
        Toast.makeText(this, "Press Again Quickly to Exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            pressTwiceToExit = false // Return to our default value

        }, 3000)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miEvents -> Toast.makeText(this, "Events Pressed", Toast.LENGTH_SHORT).show()
            R.id.miCoreTeam -> Toast.makeText(this, "Core Team Pressed", Toast.LENGTH_SHORT).show()
            R.id.miMembers -> Toast.makeText(this, "Members Pressed", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this, "Settings Pressed", Toast.LENGTH_SHORT).show()
            R.id.miLanguage -> Toast.makeText(this, "Lanuage Pressed", Toast.LENGTH_SHORT).show()
            R.id.miLogOut -> {
                val exitAlertDialog = AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_action_exit)
                    .setTitle("Exit")
                    .setCancelable(false)
                    .setMessage("Do you want to exit?!")
                    .setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                        finish()
                    }
                    .setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                        dialogInterface.cancel()

                    }.create()

                exitAlertDialog.show()
            }

        }
        return true
    }
}

