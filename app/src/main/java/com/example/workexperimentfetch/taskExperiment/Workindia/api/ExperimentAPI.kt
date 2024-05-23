package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.api

import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentDto
import retrofit2.http.GET
import retrofit2.Response
interface ExperimentAPI {
    @GET("/fact")
    suspend fun getExperiments():Response<List<ExperimentDto>>

}