package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote

import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.api.ExperimentAPI
import javax.inject.Inject

interface ExperimentRepo  {
    suspend fun getExperiments(): List<ExperimentDto>

}