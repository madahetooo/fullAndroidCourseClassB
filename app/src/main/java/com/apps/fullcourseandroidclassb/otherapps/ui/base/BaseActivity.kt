package com.apps.fullcourseandroidclassb.otherapps.ui.base

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ActivityBaseBinding
import com.apps.fullcourseandroidclassb.otherapps.ui.loginsystem.LoginActivity
import com.apps.fullcourseandroidclassb.otherapps.ui.others.BullsCarsActivity
import com.apps.fullcourseandroidclassb.otherapps.ui.others.Counter
import com.apps.fullcourseandroidclassb.otherapps.ui.others.ImageViewExample
import com.google.firebase.auth.FirebaseAuth

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCurrentFragment(Counter())
        auth = FirebaseAuth.getInstance()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miCounter -> {
                    val fragmentCounter = Counter()
                    setCurrentFragment(fragmentCounter)
                    binding.drawerLayout.close()

                }
                R.id.miImageViewExample -> {
                    val fragmentImageViewExample = ImageViewExample()
                    setCurrentFragment(fragmentImageViewExample)
                    binding.drawerLayout.close()
                }
                R.id.miBullsCars -> {
                    val fragmentBullsCars = BullsCarsActivity()
                    setCurrentFragment(fragmentBullsCars)
                    binding.drawerLayout.close()
                }
                R.id.miLogOut -> {
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
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.clContent,fragment)
            commit()
        }


}