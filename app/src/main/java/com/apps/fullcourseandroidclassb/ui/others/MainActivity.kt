package com.apps.fullcourseandroidclassb.ui.others

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import kotlinx.android.synthetic.main.activity_main.view.*

@Suppress("DEPRECATION")
class MainActivity : Fragment() {
    var pressTwiceToExit = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_main, container, false)
        view.btnApply.setOnClickListener {
            val firstName = view.etFirstName.text.toString()
            val lastName = view.etLastName.text.toString()
            val birthDate = view.etBirthDate.text.toString()
            val country = view.etCountry.text.toString()
            Toast.makeText(
                activity, "Hello $firstName $lastName," +
                        " you born in $birthDate, in $country", Toast.LENGTH_LONG
            ).show()
//
//            Toast(this).apply {
//               duration = Toast.LENGTH_LONG
//                view = layoutInflater.inflate(R.layout.custom_taost,clToast)
//                show()
//            }
        }

        val namesList = listOf("Mustapha", "Osama", "Imen", "Rayen", "Chiraz", "Amel", "Eslam")
        val namesAdapter =
            activity?.let { ArrayAdapter<String>(it,
                R.layout.support_simple_spinner_dropdown_item, namesList) }

        view.spMonths.adapter = namesAdapter
        view.spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                Toast.makeText(
                    activity,
                    "You selected ${parent!!.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT
                ).show()
            }


            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
        return view
    }

}


//override fun onBackPressed() {
//    if (pressTwiceToExit) { // current value is TRUE
//        finish() // when it is TRUE, Close the application
//        super.onBackPressed()
//    }
//    pressTwiceToExit = true // Reassign to be TRUE
//    Toast.makeText(this, "Press Again Quickly to Exit", Toast.LENGTH_SHORT).show()
//    Handler().postDelayed({
//        pressTwiceToExit = false // Return to our default value
//
//    }, 3000)
//}
//
//override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//    menuInflater.inflate(R.menu.app_bar_menu_item, menu)
//    return true
//}
//
//override fun onOptionsItemSelected(item: MenuItem): Boolean {
//    when (item.itemId) {
//        R.id.miEvents -> Toast.makeText(this, "Events Pressed", Toast.LENGTH_SHORT).show()
//        R.id.miCoreTeam -> Toast.makeText(this, "Core Team Pressed", Toast.LENGTH_SHORT).show()
//        R.id.miMembers -> Toast.makeText(this, "Members Pressed", Toast.LENGTH_SHORT).show()
//        R.id.miSettings -> Toast.makeText(this, "Settings Pressed", Toast.LENGTH_SHORT).show()
//        R.id.miLanguage -> Toast.makeText(this, "Lanuage Pressed", Toast.LENGTH_SHORT).show()
//        R.id.miLogOut -> {
//            val exitAlertDialog = AlertDialog.Builder(this)
//                .setIcon(R.drawable.ic_action_exit)
//                .setTitle("Exit")
//                .setCancelable(false)
//                .setMessage("Do you want to exit?!")
//                .setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
//                    finish()
//                }
//                .setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
//                    dialogInterface.cancel()
//
//                }.create()
//
//            exitAlertDialog.show()
//        }
//
//    }
//    return true
//}


