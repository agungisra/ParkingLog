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
import org.d3if3022.mobpro1assesment2.model.hitungBiaya


class HitungMobilViewModel(private val db: BiayaDao) : ViewModel() {

    private val hasilBiaya = MutableLiveData<HasilBiaya?>()

    fun hitungBiaya(nopol: String, merk : String, warna : String, parkingTime: Int) {

        val dataBiaya = BiayaEntity(
            nopol = nopol,
            merk = merk,
            warna = warna,
            waktu = parkingTime
        )

        hasilBiaya.value= dataBiaya.hitungBiaya()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataBiaya)
            }
        }
    }

    fun getHasilBiaya() = hasilBiaya

}