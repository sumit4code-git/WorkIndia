package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentData

@Dao
interface ExperimentDao {
    @Query("SELECT * FROM experiment_table")
    suspend fun getAllExperiments(): LiveData<List<ExperimentData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(experiments: List<ExperimentData>)

    @Query("DELETE FROM experiment_table WHERE lastCached < :expiryTime")
    suspend fun deleteExpiredExperiments(expiryTime: Long)
}