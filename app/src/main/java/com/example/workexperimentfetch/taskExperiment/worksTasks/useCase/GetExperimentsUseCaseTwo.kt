package com.example.workexperimentfetch.taskExperiment.worksTasks.useCase

import com.example.workexperimentfetch.taskExperiment.worksTasks.Resource
import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentData
import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentDto
import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentRepo
import javax.inject.Inject

class GetExperimentsUseCaseTwo @Inject constructor(
    val experimentRepo: ExperimentRepo
) {
    suspend fun execute(): Resource<ExperimentData> {
        return try {
            val response = experimentRepo.getExperiments()
            if (response.isSuccessful) {
                val experiments = response.body().toExperiment()
                Resource.Success(experiments)
            } else {
                Resource.Error("Failed to fetch experiments: ${response.code()} - $")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred: ${e.message}")
        }
    }

    // Extension function to convert ExperimentDto to Experiment entity
    private fun ExperimentDto?.toExperiment(): ExperimentData {
        return ExperimentData(
            experimentName = this?.experimentName ?: "",
            isEnabled = this?.isEnabled ?: "",
            experimentValue = this?.experimentValue ?: emptyList(),
        )
    }
}
