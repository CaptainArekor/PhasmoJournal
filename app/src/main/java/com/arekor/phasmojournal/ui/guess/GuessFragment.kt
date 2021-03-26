package com.arekor.phasmojournal.ui.guess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.arekor.phasmojournal.R
import com.arekor.phasmojournal.components.fragment.FragmentBase
import com.arekor.phasmojournal.components.fragment.FragmentBaseListener

class GuessFragment : FragmentBase<FragmentBaseListener>() {

    private lateinit var guessViewModel: GuessViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        guessViewModel = ViewModelProvider(this).get(GuessViewModel::class.java)
        val root = inflater.inflate(fragmentLayout, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        guessViewModel.text.observe(viewLifecycleOwner, {
            textView.text = getString(R.string.locale_display_fr)
        })
        return root
    }

    override val fragmentLayout: Int = R.layout.fragment_guess
}