package com.arekor.phasmojournal.ui.journal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arekor.phasmojournal.R
import com.arekor.phasmojournal.components.fragment.FragmentBase
import com.arekor.phasmojournal.components.fragment.FragmentBaseListener

class JournalFragment : FragmentBase<FragmentBaseListener>(){

    private lateinit var journalViewModel: JournalViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        journalViewModel = ViewModelProvider(this).get(JournalViewModel::class.java)
        val root = inflater.inflate(fragmentLayout, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        journalViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override val fragmentLayout: Int = R.layout.fragment_journal
}