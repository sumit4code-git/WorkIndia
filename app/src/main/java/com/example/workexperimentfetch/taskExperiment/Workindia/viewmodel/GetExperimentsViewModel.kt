package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workexperimentfetch.taskExperiment.Workindia.Response
import com.example.workexperimentfetch.taskExperiment.Workindia.useCase.GetExperimentsUseCaseTwo
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetExperimentsViewModel @Inject constructor(
    val getExperimentsUseCaseTwo: GetExperimentsUseCaseTwo
) : ViewModel() {
    private val _experiments = MutableStateFlow<Response<List<ExperimentData>>?>(null)
    val experiments = _experiments.asStateFlow()
    fun getExperiment(){
        viewModelScope.launch {
            _experiments.value = getExperimentsUseCaseTwo.execute()
        }
    }

}