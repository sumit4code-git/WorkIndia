package com.example.workexperimentfetch.taskExperiment.worksTasks.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.workexperimentfetch.taskExperiment.worksTasks.local.dao.ExperimentDao
import com.example.workexperimentfetch.taskExperiment.worksTasks.local.entity.ExperimentEntity
import com.google.gson.Gson

@Database(entities = [ExperimentEntity::class],version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ExperimentDb:RoomDatabase() {
    abstract fun experimentDao(): ExperimentDao
    companion object {
        @Volatile
        var instance:ExperimentDb? = null
    }

}

@Synchronized
fun Context.createRoomDb():ExperimentDb{
    return ExperimentDb.instance?: synchronized(this){
        val inst = Room.databaseBuilder(this,ExperimentDb::class.java, "experiment_db").build()
        ExperimentDb.instance = inst
        inst
    }
}

class Converters {
    @TypeConverter
    fun listToJson(value: List<String>?): String {
        return Gson().toJson(value)
    }
    @TypeConverter
    fun jsonToList(value:String):List<String>{
        return Gson().fromJson(value,Array<String>::class.java).toList()
    }
}