package com.apps.fullcourseandroidclassb

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.apps.fullcourseandroidclassb.breakingbadapp.ui.BreakingBad
import com.apps.fullcourseandroidclassb.clothesapp.ui.ClothesApp
import com.apps.fullcourseandroidclassb.databinding.ActivityMotherOfTheAppsBinding
import com.apps.fullcourseandroidclassb.otherapps.ui.base.BaseActivity
import com.apps.fullcourseandroidclassb.otherapps.ui.base.HomeActivity
import com.apps.fullcourseandroidclassb.otherapps.ui.loginsystem.LoginActivity
import com.apps.fullcourseandroidclassb.pushnotification.ui.CloudMessagingApp
import com.apps.fullcourseandroidclassb.shoppinglist.ui.ShoppingActivity
import com.google.firebase.auth.FirebaseAuth

class MotherOfTheApps : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMotherOfTheAppsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding = ActivityMotherOfTheAppsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnTodolistAndCalculator.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.btnBullsCarsAndCounter.setOnClickListener {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
        }
        binding.btnBreakingBadApp.setOnClickListener {
            val intent = Intent(this, BreakingBad::class.java)
            startActivity(intent)
        }
        binding.btnPushNotificationApp.setOnClickListener {
            val intent = Intent(this, CloudMessagingApp::class.java)
            startActivity(intent)
        }
        binding.btnClothesApp.setOnClickListener {
            val intent = Intent(this, ClothesApp::class.java)
            startActivity(intent)
        }
        binding.btnShoppingItemApp.setOnClickListener {
            val intent = Intent(this, ShoppingActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        val exitAlertDialog = AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_action_exit)
            .setTitle("Exit")
            .setCancelable(false)
            .setMessage("Do you want to exit?!")
            .setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                auth.signOut()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()                }
            .setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.cancel()
            }
        val alertDialog = exitAlertDialog.create()
        alertDialog.show()
    }
}