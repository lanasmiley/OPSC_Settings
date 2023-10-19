package com.example.opsc_settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var settingsManager: SettingsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        settingsManager = SettingsManager(this)


        settingsManager = SettingsManager(this)

        val metricSwitch = findViewById<Switch>(R.id.metricSwitch)
        val distanceSeekBar = findViewById<SeekBar>(R.id.distanceSeekBar)
        val distanceKilometersTextView = findViewById<TextView>(R.id.distanceKilometersTextView)
        val distanceMilesTextView = findViewById<TextView>(R.id.distanceMilesTextView)

        metricSwitch.isChecked = settingsManager.isMetricSystem()
        distanceSeekBar.progress = settingsManager.getMaxTravelDistance()

        distanceKilometersTextView.text = "Max Travel Distance: ${distanceSeekBar.progress} kilometers"
        distanceMilesTextView.text = "Max Travel Distance: ${convertToMiles(distanceSeekBar.progress)} miles"

        // Determine initial visibility
        if (metricSwitch.isChecked) {
            distanceKilometersTextView.visibility = View.VISIBLE
            distanceMilesTextView.visibility = View.GONE
        } else {
            distanceKilometersTextView.visibility = View.GONE
            distanceMilesTextView.visibility = View.VISIBLE
        }

        metricSwitch.setOnCheckedChangeListener { _, isChecked ->
            settingsManager.setMetricSystem(isChecked)
            if (isChecked) {
                distanceKilometersTextView.visibility = View.VISIBLE
                distanceMilesTextView.visibility = View.GONE
            } else {
                distanceKilometersTextView.visibility = View.GONE
                distanceMilesTextView.visibility = View.VISIBLE
            }
        }

        distanceSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (metricSwitch.isChecked) {
                    distanceKilometersTextView.text = "Max Travel Distance: $progress kilometers"
                } else {
                    distanceMilesTextView.text = "Max Travel Distance: ${convertToMiles(progress)} miles"
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                settingsManager.setMaxTravelDistance(seekBar?.progress ?: 0)
            }
        })
    }

    private fun convertToMiles(kilometers: Int): Double {
        // Conversion factor: 1 kilometer = 0.621371 miles
        return kilometers * 0.621371
    }
}