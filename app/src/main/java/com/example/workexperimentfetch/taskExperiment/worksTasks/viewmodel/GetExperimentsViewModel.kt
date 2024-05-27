package com.example.workexperimentfetch.taskExperiment.worksTasks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workexperimentfetch.taskExperiment.worksTasks.Resource
import com.example.workexperimentfetch.taskExperiment.worksTasks.local.entity.ExperimentEntity
import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentData
import com.example.workexperimentfetch.taskExperiment.worksTasks.useCase.GetExperimentsUseCase
import com.example.workexperimentfetch.taskExperiment.worksTasks.useCase.GetExperimentsUseCaseTwo
import com.example.workexperimentfetch.taskExperiment.worksTasks.useCase.SetExperimentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetExperimentsViewModel @Inject constructor(
    val getExperimentsUseCaseTwo: GetExperimentsUseCaseTwo,
    val setExperimentsUseCase: SetExperimentsUseCase,
    val getExperimentsUseCase: GetExperimentsUseCase
) : ViewModel() {
    private val _experiments = MutableStateFlow<Resource<ExperimentData>?>(Resource.Empty())
    val experiments = _experiments.asStateFlow()

    private val _experimentsLocal = MutableStateFlow<List<ExperimentEntity>?>(null)
    val experimentsLocal = _experimentsLocal.asStateFlow()
    fun getExperiment() {

        viewModelScope.launch {
            _experiments.value = Resource.Loading()
            _experiments.value = getExperimentsUseCaseTwo.execute()
        }

        viewModelScope.launch(Dispatchers.IO) {
            setExperimentsUseCase.execute(ExperimentEntity(name = "sumit", tests = listOf("t1", "t2")))
        }
        viewModelScope.launch(Dispatchers.IO) {
            _experimentsLocal.value =  getExperimentsUseCase.execute(1)
        }
    }

}