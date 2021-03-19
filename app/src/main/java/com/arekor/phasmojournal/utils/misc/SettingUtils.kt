package com.arekor.phasmojournal.utils.misc

import android.content.Context
import com.arekor.phasmojournal.R
import java.util.*

object SettingUtils {
    fun getLanguageList(context: Context) : Array<String> = arrayOf(
        context.getString(R.string.locale_display_en),
        context.getString(R.string.locale_display_fr)
    ).sortedArray()

    fun setLocale(context: Context, locale_text: String){
        val locale = Locale(locale_text)
        val resources = context.resources
        val config = resources.configuration
        val displayMetrics = resources.displayMetrics
        config.setLocale(Locale(locale_text.toLowerCase(Locale.ROOT)))
        Locale.setDefault(locale)
        context.createConfigurationContext(config)
        resources.updateConfiguration(config, displayMetrics)
    }

    fun getDisplayLanguage(context: Context, locale: Locale) : String {
        return when(locale.language) {
            context.resources.getString(R.string.locale_en) -> {
                context.resources.getString(R.string.locale_display_en)
            }
            context.resources.getString(R.string.locale_fr) -> {
                context.resources.getString(R.string.locale_display_fr)
            }
            else -> {
                context.resources.getString(R.string.locale_display_en)
            }
        }
    }
}