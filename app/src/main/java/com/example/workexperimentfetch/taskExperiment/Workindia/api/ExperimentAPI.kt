package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.api

import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentDto
import retrofit2.http.GET

interface ExperimentAPI {
    @GET("/get-experiments")
    suspend fun getExperiments():List<ExperimentDto>

}