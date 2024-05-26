package com.example.workexperimentfetch.taskExperiment.worksTasks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workexperimentfetch.taskExperiment.worksTasks.Resource
import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentData
import com.example.workexperimentfetch.taskExperiment.worksTasks.useCase.GetExperimentsUseCaseTwo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetExperimentsViewModel @Inject constructor(
    val getExperimentsUseCaseTwo: GetExperimentsUseCaseTwo
) : ViewModel() {
    private val _experiments = MutableStateFlow<Resource<ExperimentData>?>(Resource.Empty())
    val experiments = _experiments.asStateFlow()
    fun getExperiment() {

        viewModelScope.launch {
            _experiments.value = Resource.Loading()
            _experiments.value = getExperimentsUseCaseTwo.execute()
        }
    }

}