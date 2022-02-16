package com.apps.fullcourseandroidclassb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    var pressTwiceToExit = false

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        val sharedPreferencesFile = getSharedPreferences("loginDataFile", MODE_PRIVATE)
        val editor = sharedPreferencesFile.edit()
        val currentUserName = sharedPreferencesFile.getString("userNameKey", null)
        val currentPassword = sharedPreferencesFile.getString("passwordKey", null)
        val currentCheckBoxStatus = sharedPreferencesFile.getBoolean("checkBoxStatusKey", false)
        etUserName.setText(currentUserName)
        etPassword.setText(currentPassword)
        chkRememberMe.isChecked = currentCheckBoxStatus
        chkRememberMe.setOnClickListener {
            val userName = etUserName.text.toString()
            val password = etPassword.text.toString()
            val checkBoxStatus = chkRememberMe.isChecked
            editor.apply {
                putString("userNameKey", userName)
                putString("passwordKey", password)
                putBoolean("checkBoxStatusKey", checkBoxStatus)
                apply()
            }
            Toast.makeText(this, "Data saved Successfully", Toast.LENGTH_LONG).show()

        }
        btnLogin.setOnClickListener {
            val userName = etUserName.text.toString()
            val password = etPassword.text.toString()
            if (userName.isEmpty() && password.isNotEmpty()) {
                etUserName.setError("Please enter Username")

            } else if (password.isEmpty() && userName.isNotEmpty()) {
                etPassword.setError("Please enter Password")
            } else if (userName.isEmpty() && password.isEmpty()) {
                etUserName.setError("Please enter Username")
                etPassword.setError("Please enter Password")
                Toast.makeText(this, "Please fill the required data", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, BullsCarsActivity::class.java)
                startActivity(intent)
            }

        }
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
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
}