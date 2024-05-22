package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.local.dao.ExperimentDao
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentData

@Database(entities = [ExperimentData::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun experimentDao(): ExperimentDao
}

class Converters {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",")
    }

    @TypeConverter
    private fun fromList(list: List<String>): String {
        return list.joinToString(",")
    }
}