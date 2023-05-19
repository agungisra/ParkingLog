package org.d3if3022.mobpro1assesment2.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.d3if3022.mobpro1assesment2.model.HasilBiaya

@Entity(tableName = "biaya")
data class BiayaEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var nopol: String,
    var merk: String,
    var warna: String,
    var biaya: Int
)