package com.apps.fullcourseandroidclassb.otherapps.ui.loginsystem

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ActivityLoginBinding
import com.apps.fullcourseandroidclassb.otherapps.ui.base.HomeActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


const val REQUEST_CODE_SIGN_IN = 0

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    var pressTwiceToExit = false
    private lateinit var auth: FirebaseAuth

    @SuppressLint("CommitPrefEdits")
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        supportActionBar?.hide()
        val sharedPreferencesFile =
            getSharedPreferences("loginDataFile", AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPreferencesFile.edit()
        //GET DATA
        val currentUserName = sharedPreferencesFile.getString("userNameKey", null)
        val currentPassword = sharedPreferencesFile.getString("passwordKey", null)
        val currentCheckBoxStatus = sharedPreferencesFile.getBoolean("checkBoxStatusKey", false)
        //SET DATA
        binding.etUserNameLogin.setText(currentUserName)
        binding.etPasswordLogin.setText(currentPassword)
        binding.chkRememberMe.isChecked = currentCheckBoxStatus
        binding.chkRememberMe.setOnClickListener {

            //SET DATA TO SHRED PREFRENCES
            val userName = binding.etUserNameLogin.text.toString()
            val password = binding.etPasswordLogin.text.toString()
            val checkBoxStatus = binding.chkRememberMe.isChecked
            editor.apply {
                putString("userNameKey", userName)
                putString("passwordKey", password)
                putBoolean("checkBoxStatusKey", checkBoxStatus)
                apply()
            }
            Toast.makeText(this, "Data saved Successfully", Toast.LENGTH_LONG).show()

        }
        binding.btnLogin.setOnClickListener {
            val userName = binding.etUserNameLogin.text.toString()
            val password = binding.etPasswordLogin.text.toString()
            if (userName.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(userName, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
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
                        }
                    }
            }

        }
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
//            finish()
        }
        binding.btnSignInWithGoogle.setOnClickListener {
            val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail()
                .build()


            val signInClient = GoogleSignIn.getClient(this, options)
            signInClient.signInIntent.also {
                startActivityForResult(it, REQUEST_CODE_SIGN_IN)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_SIGN_IN) {
            val gmailAccount = GoogleSignIn.getSignedInAccountFromIntent(data).result
            gmailAccount?.let {
                googleAuthForFirebase(gmailAccount)
            }
        }
    }

    private fun googleAuthForFirebase(gmailAccount: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(gmailAccount.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
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
}
