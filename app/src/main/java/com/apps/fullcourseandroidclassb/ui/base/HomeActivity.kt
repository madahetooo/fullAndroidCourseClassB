package com.apps.fullcourseandroidclassb.ui.base

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.ui.loginsystem.LoginActivity
import com.apps.fullcourseandroidclassb.ui.others.Calculator
import com.apps.fullcourseandroidclassb.ui.others.MainActivity
import com.apps.fullcourseandroidclassb.ui.others.RestaurantMenu
import com.apps.fullcourseandroidclassb.ui.todolist.TodoListApplication
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        auth = FirebaseAuth.getInstance()
        setCurrentFragment(TodoListApplication())
        val fragmentTodoList = TodoListApplication()
        val fragmentRestaurant = RestaurantMenu()
        val fragmentCalculator = Calculator()
        val fragmentProfile = MainActivity()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miTodoListApp -> setCurrentFragment(fragmentTodoList)
                R.id.miRestaurant -> setCurrentFragment(fragmentRestaurant)
                R.id.miCalculator -> setCurrentFragment(fragmentCalculator)
                R.id.miProfile -> setCurrentFragment(fragmentProfile)
            }
            true
        }
        bottomNavigationView.getOrCreateBadge(R.id.miTodoListApp).apply {
            number = 10
            isVisible = true
        }

    }

private fun setCurrentFragment(fragment: Fragment)=
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment,fragment)
        commit()
    }

    override fun onBackPressed() {
        val exitAlertDialog = AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_action_exit)
            .setTitle("Exit")
            .setCancelable(false)
            .setMessage("Do you want to exit?!")
            .setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                auth.signOut() //LOGOUT
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            .setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.cancel()

            }
        val alertDialog = exitAlertDialog.create()
        alertDialog.show()
    }
}