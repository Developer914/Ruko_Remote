package com.example.roku.util.ext

import android.content.Context
import android.content.SharedPreferences

object AppPrefes {

    private const val PREFS_NAME = "AppPreferences"
    private const val ONBOARDING_VISITED = "onboarding_visited"


    private lateinit var sharedPreferences: SharedPreferences

    // Initialize SharedPreferences (Call this in Application class or MainActivity)
    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    // Set Sound Enabled
    fun setOnboardingVisited(isEnabled: Boolean) {
        sharedPreferences.edit().putBoolean(ONBOARDING_VISITED, isEnabled).apply()
    }

    // Get Sound Enabled
    fun isOnboardingVisited(): Boolean {
        return sharedPreferences.getBoolean(ONBOARDING_VISITED, false) // Default is true
    }
}
