package com.arekor.phasmojournal.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.arekor.phasmojournal.MainActivity
import com.arekor.phasmojournal.R
import com.arekor.phasmojournal.utils.misc.SettingUtils

class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel
    private var currentActivity : MainActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentActivity = requireActivity() as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)

        val localeList : Array<String> = currentActivity?.getLanguageList() ?: arrayOf()
        val localeAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_item,
            localeList
        )
        val localeSpinner: Spinner = root.findViewById(R.id.settings_locale_spinner)
        localeSpinner.adapter = localeAdapter
        val defaultText = SettingUtils.getDisplayLanguage(requireContext(), requireContext().resources.configuration.locales.get(0))
        localeSpinner.setSelection(localeAdapter.getPosition(defaultText))
        localeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                settingsViewModel.localeIndex = position

                when(localeSpinner.selectedItem.toString()){
                    getString(R.string.locale_display_en) -> {currentActivity?.setLocale(getString(R.string.locale_en))}
                    getString(R.string.locale_display_fr) -> {currentActivity?.setLocale(getString(R.string.locale_fr))}
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        return root
    }
}