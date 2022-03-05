package com.apps.fullcourseandroidclassb.ui.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.ui.base.BaseActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        // Initialize Firebase Auth
        auth = Firebase.auth
        supportActionBar?.hide()
        btnRegister.setOnClickListener {

            val emailAddress = etEmailAddress.text.toString() //GET EMAILADDRESS DATA
            val password = etEmailAddress.text.toString() //GET PASSWORD
            if (emailAddress.isNotEmpty() && password.isNotEmpty()){
                auth.createUserWithEmailAndPassword(emailAddress,password).addOnCompleteListener(this){
                    task ->
                    if (task.isSuccessful){
                        Toast.makeText(this,"Sign Up Successfully, Welcome",Toast.LENGTH_LONG).show()
                        val intent = Intent(this, BaseActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this,"ERROR",Toast.LENGTH_LONG).show()
                    }
                }
            }




            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
            finish()
        }
        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}