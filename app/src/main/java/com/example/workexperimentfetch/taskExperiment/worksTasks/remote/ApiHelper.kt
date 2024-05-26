package com.example.workexperimentfetch.taskExperiment.worksTasks.remote

import retrofit2.Retrofit

object ApiHelper {

    val baseUrl = "https://catfact.ninja"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(ApiWorker.gsonConverter)
            .client(ApiWorker.client)
            .build()
    }
}
