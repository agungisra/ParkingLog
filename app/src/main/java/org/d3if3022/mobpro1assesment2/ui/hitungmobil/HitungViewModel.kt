package org.d3if3022.mobpro1assesment2.ui.hitungmobil

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3022.mobpro1assesment2.db.BiayaDao
import org.d3if3022.mobpro1assesment2.db.BiayaEntity
import org.d3if3022.mobpro1assesment2.model.HasilBiaya


class HitungViewModel(private val db: BiayaDao) : ViewModel() {

    private val hasilBiaya = MutableLiveData<HasilBiaya?>()

    val data = db.getLastBiaya()

    fun hitungBiaya(parkingTime: Int) {
        val biaya = parkingTime * 5000
        hasilBiaya.value = HasilBiaya(biaya)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataBiaya = BiayaEntity(
                    biaya = parkingTime
                )
                db.insert(dataBiaya)
            }
        }
    }

    fun getHasilBiaya() = hasilBiaya

}