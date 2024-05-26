package  com.example.workexperimentfetch.taskExperiment.worksTasks.local.dao

//@Dao
//interface ExperimentDao {
//    @Query("SELECT * FROM experiment_table")
//    suspend fun getAllExperiments(): LiveData<List<ExperimentData>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(experiments: List<ExperimentData>)
//
//    @Query("DELETE FROM experiment_table WHERE lastCached < :expiryTime")
//    suspend fun deleteExpiredExperiments(expiryTime: Long)
//}