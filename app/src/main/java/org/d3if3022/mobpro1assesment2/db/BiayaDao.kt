package org.d3if3022.mobpro1assesment2.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BiayaDao {
    @Insert
    fun insert(biaya: BiayaEntity)

    @Query("SELECT * FROM biaya ORDER BY id DESC")
    fun getLastBiaya(): LiveData<List<BiayaEntity?>>

    @Query("DELETE FROM biaya")
    fun clearData()

    @Delete
    fun deleteData(biaya: BiayaEntity)
}
