package org.d3if3022.mobpro1assesment2.ui.hitungmotor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3022.mobpro1assesment2.db.BiayaDao

class HitungMotorViewModelFactory(
    private val db: BiayaDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HitungMotorViewModel::class.java)) {
            return HitungMotorViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}