package com.apps.fullcourseandroidclassb.ui.loginsystem

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.ui.base.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    var pressTwiceToExit = false
    private lateinit var auth: FirebaseAuth

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        Firebase.auth.signOut()
            //val currentUser = auth.currentUser
        supportActionBar?.hide()
        val sharedPreferencesFile = getSharedPreferences("loginDataFile", MODE_PRIVATE)
        val editor = sharedPreferencesFile.edit()

        //GET DATA
        val currentUserName = sharedPreferencesFile.getString("userNameKey", null)
        val currentPassword = sharedPreferencesFile.getString("passwordKey", null)
        val currentCheckBoxStatus = sharedPreferencesFile.getBoolean("checkBoxStatusKey", false)

        //SET DATA
        etUserName.setText(currentUserName)
        etPassword.setText(currentPassword)
        chkRememberMe.isChecked = currentCheckBoxStatus
        chkRememberMe.setOnClickListener {

            //SET DATA TO SHRED PREFRENCES
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
            if (userName.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(userName, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser

                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
//                                updateUI(null)
                        }
                    }

//                auth.signInWithEmailAndPassword(userName, password)
//                    .addOnCompleteListener(this) { task ->
//                        if (task.isSuccessful) {
//                            Toast.makeText(this, "Sign in Successfully, Welcome", Toast.LENGTH_LONG)
//                                .show()
//                            val intent = Intent(this, HomeActivity::class.java)
//                            startActivity(intent)
//                            finish()
//                        } else {
//                            Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show()
//                        }
//                    }
            }

        }
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
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

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
