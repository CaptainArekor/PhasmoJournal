package com.arekor.phasmojournal

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.arekor.phasmojournal.utils.misc.SettingUtils
import com.arekor.phasmojournal.utils.storage.SharedPreferencesUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadStoredLocale()
        setNavigation()
    }

    private fun loadStoredLocale() {
        setLocale(SharedPreferencesUtils.getLocalePreference(this))
    }

    private fun setNavigation() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = getNavController()
        navView.setupWithNavController(navController)
    }

    private fun getNavController() = findNavController(R.id.nav_host_fragment)

    fun setLocale(locale_text: String) {
        if(resources.configuration.locales.get(0).language != locale_text) {
            SettingUtils.setLocale(this, locale_text)
        }
    }

    fun getLanguageList() : Array<String> = SettingUtils.getLanguageList(this)
}