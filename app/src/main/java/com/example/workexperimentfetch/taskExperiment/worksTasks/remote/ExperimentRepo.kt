package com.example.workexperimentfetch.taskExperiment.worksTasks.remote

import retrofit2.Response

interface ExperimentRepo {
    suspend fun getExperiments(): Response<ExperimentDto>

}