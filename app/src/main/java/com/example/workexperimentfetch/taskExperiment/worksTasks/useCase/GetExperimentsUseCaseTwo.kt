package com.example.workexperimentfetch.taskExperiment.worksTasks.useCase

import com.example.workexperimentfetch.taskExperiment.worksTasks.Response
import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentData
import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentDto
import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentRepo
import javax.inject.Inject

class GetExperimentsUseCaseTwo @Inject constructor(
    val experimentRepo: ExperimentRepo
) {
    suspend fun execute(): Response<ExperimentData> {
        return try {
            val response = experimentRepo.getExperiments()
            if (response.isSuccessful) {
                val experiments = response.body().toExperiment()
                Response.Success(experiments)
            } else {
                Response.Failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    // Extension function to convert ExperimentDto to Experiment entity
    private fun ExperimentDto?.toExperiment(): ExperimentData {
        return ExperimentData(
            experimentName = this?.experimentName?:"",
            isEnabled = this?.isEnabled?:"",
            experimentValue = this?.experimentValue?: emptyList(),
        )
    }
}
