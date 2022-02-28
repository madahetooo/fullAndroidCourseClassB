package com.apps.fullcourseandroidclassb.ui.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        supportActionBar?.hide()
        btnRegister.setOnClickListener {
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