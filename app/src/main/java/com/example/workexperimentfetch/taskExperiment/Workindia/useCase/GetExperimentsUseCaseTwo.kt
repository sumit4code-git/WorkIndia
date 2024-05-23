package com.example.workexperimentfetch.taskExperiment.Workindia.useCase

import com.example.workexperimentfetch.taskExperiment.Workindia.Response
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentData
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentDto
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentRepo
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentRepoImpl
import javax.inject.Inject

class GetExperimentsUseCaseTwo @Inject constructor(
    val experimentRepo: ExperimentRepoImpl
) {
    suspend fun execute(): Response<List<ExperimentData>> {
        return try {
            val response = experimentRepo.getExperiments()
            if (response.isSuccessful) {
                val experiments = response.body()?.map { it.toExperiment() } ?: emptyList()
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
    private fun ExperimentDto.toExperiment(): ExperimentData {
        return ExperimentData(
            experimentName = this.experimentName,
            isEnabled = this.isEnabled,
            experimentValue = this.experimentValue
        )
    }
}
