package org.d3if3022.mobpro1assesment2.ui.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3022.mobpro1assesment2.db.BiayaDao
import org.d3if3022.mobpro1assesment2.db.BiayaEntity

class HistoryViewModel(private val db: BiayaDao) : ViewModel() {
    val data = db.getLastBiaya()

    fun hapusSemuaData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }

    fun hapusData(biayaEntity: BiayaEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.deleteData(biayaEntity)
        }
    }
}