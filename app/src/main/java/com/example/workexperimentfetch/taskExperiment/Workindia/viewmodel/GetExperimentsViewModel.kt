package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentData
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.useCase.GetExperimentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetExperimentsViewModel @Inject constructor(
    val getExperimentsUseCase: GetExperimentsUseCase
) : ViewModel() {
    private val _experiments = MutableLiveData<List<ExperimentData>>()
    val experiments: LiveData<List<ExperimentData>> get() = _experiments

    init {
        viewModelScope.launch {
            getExperimentsUseCase.execute().collect { experiments ->
                _experiments.postValue(experiments)
            }
        }
    }

}