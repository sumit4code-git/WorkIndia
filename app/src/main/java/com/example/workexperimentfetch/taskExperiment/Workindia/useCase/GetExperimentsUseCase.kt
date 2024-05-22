package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.useCase

import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.local.dao.ExperimentDao
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentData
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentDto
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetExperimentsUseCase @Inject constructor(
    private val experimentRepo: ExperimentRepo,
    private val experimentDao: ExperimentDao
) {

    companion object {
        const val CACHE_EXPIRY_TIME = 8 * 60 * 60 * 1000 // 8 hours in milliseconds
    }

    suspend fun execute(): Flow<List<ExperimentData>> = flow {
        val currentTime = System.currentTimeMillis()

        // Delete expired experiments
        experimentDao.deleteExpiredExperiments(currentTime - CACHE_EXPIRY_TIME)

        // Fetch experiments from the cache
        val cachedExperiments = experimentDao.getAllExperiments().value?.map { experiments ->
            if (experiments.isEmpty()) {
                // If the cache is empty, fetch from the API
                val apiExperiments = experimentRepo.getExperiments()
                val experimentsWithTimestamp = apiExperiments.map {
                    it.toExperiment(currentTime)
                }
                // Save the fetched experiments to the cache
                experimentDao.insertAll(experimentsWithTimestamp)
                emit(experimentsWithTimestamp)
            } else {
                emit(experiments)
            }
        }

        emitAll(cachedExperiments)
    }

    // Extension function to convert ExperimentDto to Experiment entity
    private fun ExperimentDto.toExperiment(currentTime: Long): ExperimentData {
        return ExperimentData(
            experimentName = this.experimentName,
            isEnabled = this.isEnabled,
            experimentValue = this.experimentValue,
//            lastFetched = currentTime
        )
    }
}
