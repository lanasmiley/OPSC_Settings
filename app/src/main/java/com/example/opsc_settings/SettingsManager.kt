package com.example.opsc_settings



import android.content.Context
import android.content.SharedPreferences

class SettingsManager(context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)

    fun setMetricSystem(useMetric: Boolean) {
        preferences.edit().putBoolean("metric_system", useMetric).apply()
    }

    fun isMetricSystem(): Boolean {
        return preferences.getBoolean("metric_system", true) // Default to metric
    }

    fun setMaxTravelDistance(maxDistance: Int) {
        preferences.edit().putInt("max_travel_distance", maxDistance).apply()
    }

    fun getMaxTravelDistance(): Int {
        return preferences.getInt("max_travel_distance", 100) // Default to 100 kilometers
    }
}
