package com.apps.fullcourseandroidclassb.ui.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.data.local.db.ProfileInformation
import com.apps.fullcourseandroidclassb.ui.base.BaseActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistrationActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val profileInformationCollectionRef = Firebase.firestore.collection("profileInformation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        supportActionBar?.hide()
        btnRegister.setOnClickListener {
            val emailAddress = etEmailAddressRegistration.text.toString() //GET EMAILADDRESS DATA
            val password = etPasswordRegistration.text.toString() //GET PASSWORD
            val profileInformation = getProfileInformation() // CALLING THE FUNCTION THAT HOLDING THE DATA
            if (profileInformation!=null){
                saveProfileInformationData(profileInformation)
            }
            else{
                Toast.makeText(baseContext, "Fill the required data",
                    Toast.LENGTH_SHORT).show()
            }
            if (emailAddress.isNotEmpty() && password.isNotEmpty()){
                auth.createUserWithEmailAndPassword(emailAddress, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val currentUser = auth.currentUser

                            //Navigation to Home Screen
                            val intent = Intent(this, BaseActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }

        }
        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    //GETTING THE INFORMATION FROM THE LAYOUT
    private fun getProfileInformation() :ProfileInformation{
        val fullName = etFullName.text.toString()
        val userName = etUserNameRegistration.text.toString()
        val emailAddress = etEmailAddressRegistration.text.toString()
        val phoneNumber = etPhoneNumber.text.toString()
        val password = etPasswordRegistration.text.toString()
        return ProfileInformation(fullName,userName,emailAddress,phoneNumber.toInt(),password)
    }

    //SAVING DATA TO FIREBASE FIRESTOR
    private fun saveProfileInformationData(profileInformation:ProfileInformation){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                profileInformationCollectionRef.add(profileInformation)
                withContext(Dispatchers.Main){
                    Toast.makeText(this@RegistrationActivity,"Data Saved Successfully",Toast.LENGTH_LONG).show()
                }
            }
            catch (e:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@RegistrationActivity,e.message,Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}