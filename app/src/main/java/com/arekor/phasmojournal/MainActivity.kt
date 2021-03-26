package com.arekor.phasmojournal

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.arekor.phasmojournal.components.fragment.FragmentBaseListener
import com.arekor.phasmojournal.utils.misc.SettingUtils
import com.arekor.phasmojournal.utils.storage.SharedPreferencesUtils
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), FragmentBaseListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadStoredLocale()
        setNavigation()
    }

    private fun loadStoredLocale() {
        setLocale(SharedPreferencesUtils.getLocalePreference(this), false)
    }

    private fun setNavigation() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = getNavController()
        navView.setupWithNavController(navController)
    }

    private fun getNavController() = findNavController(R.id.nav_host_fragment)

    override fun setLocale(locale_text: String, requireRestart: Boolean) {
        if(resources.configuration.locales.get(0).language != locale_text) {
            SettingUtils.setLocale(this, locale_text)
            if(requireRestart) {
                restartActivity()
            }
        }
    }

    override fun getAppVersion() : String {
        return try {
            val pInfo: PackageInfo = packageManager.getPackageInfo(packageName, 0)
            val version = pInfo.versionName
            "V$version"
        } catch (e: PackageManager.NameNotFoundException) {
            ""
        }
    }

    private fun restartActivity() {
        val intent = intent
        finish()
        startActivity(intent)
    }

    fun getLanguageList() : Array<String> = SettingUtils.getLanguageList(this)
}