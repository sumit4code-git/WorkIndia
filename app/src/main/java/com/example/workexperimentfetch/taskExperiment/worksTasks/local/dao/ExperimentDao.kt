package com.example.workexperimentfetch.taskExperiment.worksTasks.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.workexperimentfetch.taskExperiment.worksTasks.local.entity.ExperimentEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface ExperimentDao {
    @Query("SELECT * FROM experiment_table")
     fun getExperiments(): List<ExperimentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun setExperiments(exp:ExperimentEntity): Long
}