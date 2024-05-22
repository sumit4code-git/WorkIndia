package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote

import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.api.ExperimentAPI
import javax.inject.Inject

class ExperimentRepoImpl @Inject constructor(val experimentAPI: ExperimentAPI): ExperimentRepo {
    override suspend fun getExperiments(): List<ExperimentDto> {
        return experimentAPI.getExperiments()
    }
}