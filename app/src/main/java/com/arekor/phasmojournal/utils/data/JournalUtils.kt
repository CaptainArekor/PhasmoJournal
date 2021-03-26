package com.arekor.phasmojournal.utils.data

import com.arekor.phasmojournal.ui.journal.JournalData

object JournalUtils {
    fun getPagesData() : ArrayList<JournalData> {
        val arrayList: ArrayList<JournalData> = ArrayList()
        arrayList.add(JournalData("Présentation des fantômes","Un fantôme est un mauvais esprit d'un personne décédée qui se nourrit de la peur des gens. Ils sont créés à partir de morts violents et soudaines. S'il sont dérangés, ils peuvent faire des ravages dans les quartiers et ils sont également connus pour avoir jusqu'à 1000 ans.\nCe guide vous aidera à comprendre ce que vous devez faire pour survivre."))
        return arrayList
    }
}