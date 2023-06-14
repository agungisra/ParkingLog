package org.d3if3022.mobpro1assesment2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BiayaEntity::class], version = 5, exportSchema = false)
abstract class BiayaDb : RoomDatabase() {

    abstract val dao: BiayaDao

    companion object {
        @Volatile
        private var INSTANCE: BiayaDb? = null
        fun getInstance(context: Context): BiayaDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BiayaDb::class.java,
                        "biaya.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
