package org.d3if3022.mobpro1assesment2.ui.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3022.mobpro1assesment2.db.BiayaDao

class HistoryViewModelFactory (private val db : BiayaDao ) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
            return HistoryViewModel(db) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}