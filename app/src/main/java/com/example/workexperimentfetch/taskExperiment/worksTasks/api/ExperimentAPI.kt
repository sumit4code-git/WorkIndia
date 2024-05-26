package com.example.workexperimentfetch.taskExperiment.worksTasks.api

import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentDto
import retrofit2.Response
import retrofit2.http.GET

interface ExperimentAPI {
    @GET("/fact")
    suspend fun getExperiments(): Response<ExperimentDto>

}