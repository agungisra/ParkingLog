package org.d3if3022.mobpro1assesment2.model

import org.d3if3022.mobpro1assesment2.db.BiayaEntity

fun BiayaEntity.hitungBiaya(): HasilBiaya {
    val biaya = waktu * 5000
    return HasilBiaya(biaya)
}