package com.arekor.phasmojournal.components.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class FragmentBase<T : FragmentBaseListener?> : Fragment() {
    var listener: FragmentBaseListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(fragmentLayout, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as FragmentBaseListener
        } catch (var3: ClassCastException) {
            listener = null
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    protected abstract val fragmentLayout: Int

    fun onBackPressed() {}
}
