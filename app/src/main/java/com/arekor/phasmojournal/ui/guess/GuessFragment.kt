package com.arekor.phasmojournal.ui.guess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.arekor.phasmojournal.R

class GuessFragment : Fragment() {

    private lateinit var guessViewModel: GuessViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        guessViewModel =
                ViewModelProvider(this).get(GuessViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        guessViewModel.text.observe(viewLifecycleOwner, {
            textView.text = getString(R.string.locale_display_fr)
        })
        return root
    }
}