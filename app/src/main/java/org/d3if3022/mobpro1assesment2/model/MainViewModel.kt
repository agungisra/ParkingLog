package org.d3if3022.mobpro1assesment2.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    private val hasilBiaya = MutableLiveData<HasilBiaya?>()

    fun hitungBiaya(parkingTime: Int) {
        val biaya = parkingTime * 5000
        hasilBiaya.value = HasilBiaya(biaya)
    }

    fun getHasilBiaya() = hasilBiaya


}