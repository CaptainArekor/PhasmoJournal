package com.arekor.phasmojournal.utils.misc

import android.content.Context
import android.content.res.Configuration
import com.arekor.phasmojournal.R
import java.util.*

object SettingUtils {
    fun getLanguageList(context: Context) : Array<String> = arrayOf(
        context.getString(R.string.locale_display_en),
        context.getString(R.string.locale_display_fr)
    ).sortedArray()

    fun setLocale(context: Context, locale_text: String){
        val config = Configuration(context.resources.configuration)
        val locale = Locale(locale_text)
        config.setLocale(locale)
        context.createConfigurationContext(config)
    }
}