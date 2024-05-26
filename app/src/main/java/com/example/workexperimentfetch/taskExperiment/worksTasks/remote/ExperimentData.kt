package com.example.workexperimentfetch.taskExperiment.worksTasks.remote

data class ExperimentData(
    val experimentName: String,
    val isEnabled: String,
    val experimentValue: List<String>,
)