package com.arekor.phasmojournal.components.fragment

interface FragmentBaseListener {
    fun setLocale(locale_text: String, requireRestart: Boolean = true)
    fun getAppVersion(): String
}
