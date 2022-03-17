package com.apps.fullcourseandroidclassb.otherapps.ui.base

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ActivityHomeBinding
import com.apps.fullcourseandroidclassb.otherapps.ui.loginsystem.LoginActivity
import com.apps.fullcourseandroidclassb.otherapps.ui.others.Calculator
import com.apps.fullcourseandroidclassb.firebasefirestoreapp.ui.MainActivity
import com.apps.fullcourseandroidclassb.otherapps.ui.others.RestaurantMenu
import com.apps.fullcourseandroidclassb.todolist.ui.TodoListApplication
import com.google.firebase.auth.FirebaseAuth

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = FirebaseAuth.getInstance()
        setCurrentFragment(TodoListApplication())
        val fragmentTodoList = TodoListApplication()
        val fragmentRestaurant = RestaurantMenu()
        val fragmentCalculator = Calculator()
        val fragmentProfile = MainActivity()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miTodoListApp -> setCurrentFragment(fragmentTodoList)
                R.id.miRestaurant -> setCurrentFragment(fragmentRestaurant)
                R.id.miCalculator -> setCurrentFragment(fragmentCalculator)
                R.id.miProfile -> setCurrentFragment(fragmentProfile)
            }
            true
        }
        binding.bottomNavigationView.getOrCreateBadge(R.id.miTodoListApp).apply {
            number = 10
            isVisible = true
        }

    }

private fun setCurrentFragment(fragment: Fragment)=
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment,fragment)
        commit()
    }

}