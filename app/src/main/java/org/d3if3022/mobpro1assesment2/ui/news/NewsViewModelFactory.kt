package org.d3if3022.mobpro1assesment2.ui.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3022.mobpro1assesment2.R
import org.d3if3022.mobpro1assesment2.network.ApiStatus
import org.d3if3022.mobpro1assesment2.network.KendaraanApi

class NewsViewModelFactory : ViewModel() {

    private val data = MutableLiveData<List<Kendaraan>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(KendaraanApi.service.getKendaraan())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("NewsViewModelFactory", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Kendaraan>> = data

    fun getStatus(): LiveData<ApiStatus> = status

}