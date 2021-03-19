package com.arekor.phasmojournal

import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.arekor.phasmojournal.utils.misc.SettingUtils
import com.arekor.phasmojournal.utils.storage.SharedPreferencesUtils
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
        val storedLocale = SharedPreferencesUtils.getLocalePreference(this)
        setLocale(storedLocale)
    }

    fun setLocale(locale_text: String) {
        SettingUtils.setLocale(this,  locale_text)
        SharedPreferencesUtils.setLocalePreference(this, locale_text)
    }

    fun getLanguageList() : Array<String> = SettingUtils.getLanguageList(this)
}