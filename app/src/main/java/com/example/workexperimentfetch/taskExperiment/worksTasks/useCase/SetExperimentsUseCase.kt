package com.example.workexperimentfetch.taskExperiment.worksTasks.useCase

import com.example.workexperimentfetch.taskExperiment.worksTasks.local.dao.ExperimentDao
import com.example.workexperimentfetch.taskExperiment.worksTasks.local.entity.ExperimentEntity
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class SetExperimentsUseCase @Inject constructor(
    val experimentDao: ExperimentDao
) {
    suspend fun execute(experiments: ExperimentEntity):Long {
        return experimentDao.setExperiments(experiments)
    }

}