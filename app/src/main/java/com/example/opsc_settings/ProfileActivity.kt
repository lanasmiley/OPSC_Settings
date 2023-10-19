package com.example.opsc_settings

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profileButton = findViewById<Button>(R.id.profileButton)
        val historyButton = findViewById<Button>(R.id.historyButton)
        val accessibilityButton = findViewById<Button>(R.id.accessibilityButton)
        val travelButton = findViewById<Button>(R.id.travelButton)
        val signOutButton = findViewById<Button>(R.id.signOutButton)

        profileButton.setOnClickListener {
            // Navigate to the user profile page
            startActivity(Intent(this, UserProfileActivity::class.java))
        }

        historyButton.setOnClickListener {
            // Navigate to the booking history page
            startActivity(Intent(this, BookingHistoryActivity::class.java))
        }

        accessibilityButton.setOnClickListener {
            // Navigate to accessibility settings
            startActivity(Intent(this, AccessibilitySettingsActivity::class.java))
        }

        travelButton.setOnClickListener {
            // Navigate to travel settings
            startActivity(Intent(this, SettingsManager::class.java))
        }

        signOutButton.setOnClickListener {
            // Implement sign-out logic here
            // For example, clear user session and go back to the login page
            // startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
