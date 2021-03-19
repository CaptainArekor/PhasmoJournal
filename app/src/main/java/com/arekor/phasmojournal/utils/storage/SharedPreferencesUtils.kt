package com.arekor.phasmojournal.utils.storage

import android.content.Context
import android.content.SharedPreferences
import com.arekor.phasmojournal.R

object SharedPreferencesUtils {
    private const val privateMode = Context.MODE_PRIVATE
    private const val preferenceName = "sharedPreferencesData"

    private const val localeKey = "sharedPreferencesLocale"

    private fun getSharedPreference(context: Context): SharedPreferences = context.getSharedPreferences(preferenceName, privateMode)

    private fun getIntegerPreference(context: Context, preferenceID: String) : Int = getSharedPreference(context).getInt(preferenceID, 0)
    private fun getStringPreference(context: Context, preferenceID: String) : String? = getSharedPreference(context).getString(preferenceID, "")
    private fun getBooleanPreference(context: Context, preferenceID: String) : Boolean = getSharedPreference(context).getBoolean(preferenceID, false)
    private fun setPreference(context: Context, preferenceID: String, value: Int) {
        getSharedPreference(context).edit().putInt(preferenceID, value).apply()
    }
    private fun setPreference(context: Context, preferenceID: String, value: String) {
        getSharedPreference(context).edit().putString(preferenceID, value).apply()
    }
    private fun setPreference(context: Context, preferenceID: String, value: Boolean) {
        getSharedPreference(context).edit().putBoolean(preferenceID, value).apply()
    }

    fun setLocalePreference(context: Context, value: String) {
        setPreference(context, localeKey, value)
    }

    fun getLocalePreference(context: Context) : String = getStringPreference(context, localeKey) ?: context.resources.getString(R.string.locale_en)
}