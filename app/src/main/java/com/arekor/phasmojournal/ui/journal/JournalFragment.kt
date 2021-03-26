package com.arekor.phasmojournal.ui.journal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.arekor.phasmojournal.R
import com.arekor.phasmojournal.components.fragment.FragmentBase
import com.arekor.phasmojournal.components.fragment.FragmentBaseListener
import com.arekor.phasmojournal.utils.data.JournalUtils


class JournalFragment : FragmentBase<FragmentBaseListener>(){
    var myViewPager2: ViewPager2? = null
    var journalAdapter: JournalAdapter? = null
    private lateinit var journalViewModel: JournalViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        journalViewModel = ViewModelProvider(this).get(JournalViewModel::class.java)
        val root = inflater.inflate(fragmentLayout, container, false)
        journalAdapter = JournalAdapter(JournalUtils.getPagesData())
        myViewPager2 = root.findViewById(R.id.journal_pager)
        myViewPager2?.adapter = journalAdapter;
        return root
    }

    override val fragmentLayout: Int = R.layout.fragment_journal
}