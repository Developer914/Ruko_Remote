package com.example.roku.application

import android.app.Application
import android.content.ContextWrapper
import com.example.roku.util.ext.AppPrefes
import com.pixplicity.easyprefs.library.Prefs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RukoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppPrefes.init(this)
        configurePreferences()
    }

    private fun configurePreferences() {
        // Initialize the Prefs class
        Prefs.Builder().setContext(this).setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName).setUseDefaultSharedPreference(true).build()
    }
}