package com.arekor.phasmojournal.ui.journal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arekor.phasmojournal.R


class JournalAdapter(private val pages: ArrayList<JournalData>) :
    RecyclerView.Adapter<JournalAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_page, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = pages[position].title
        holder.content.text = pages[position].content
    }

    override fun getItemCount(): Int = pages.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.page_title)
        var content: TextView = itemView.findViewById(R.id.page_content)

    }
}