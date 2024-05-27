package com.example.workexperimentfetch.taskExperiment.worksTasks.useCase

import com.example.workexperimentfetch.taskExperiment.worksTasks.local.dao.ExperimentDao
import com.example.workexperimentfetch.taskExperiment.worksTasks.local.db.ExperimentDb
import com.example.workexperimentfetch.taskExperiment.worksTasks.local.entity.ExperimentEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class GetExperimentsUseCase @Inject constructor(
    val experimentDao: ExperimentDao
) {
    suspend fun execute(id: Int):List<ExperimentEntity> {
        return  experimentDao.getExperiments()
    }

}