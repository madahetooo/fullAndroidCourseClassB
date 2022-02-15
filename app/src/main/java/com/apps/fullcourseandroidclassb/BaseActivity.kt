package com.apps.fullcourseandroidclassb

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullcourseandroidclassb.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miProfile -> Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                R.id.miGroup -> Toast.makeText(this, "My Group", Toast.LENGTH_SHORT).show()
                R.id.miSettingsNumber2 -> Toast.makeText(this, "Settings2", Toast.LENGTH_SHORT)
                    .show()
                R.id.miLanguageNew -> Toast.makeText(this, "My Languages", Toast.LENGTH_SHORT)
                    .show()
                R.id.miSend -> Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show()
                R.id.miArchive -> Toast.makeText(this, "Archive", Toast.LENGTH_SHORT).show()
                R.id.miLogOut2 -> Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
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
}