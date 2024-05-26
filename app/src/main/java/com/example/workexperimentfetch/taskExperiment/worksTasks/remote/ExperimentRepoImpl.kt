package com.example.workexperimentfetch.taskExperiment.worksTasks.remote

import com.example.workexperimentfetch.taskExperiment.worksTasks.api.ExperimentAPI
import retrofit2.Response
import javax.inject.Inject

class ExperimentRepoImpl @Inject constructor(val experimentAPI: ExperimentAPI) : ExperimentRepo {
    override suspend fun getExperiments(): Response<ExperimentDto> {
        return experimentAPI.getExperiments()
    }
}