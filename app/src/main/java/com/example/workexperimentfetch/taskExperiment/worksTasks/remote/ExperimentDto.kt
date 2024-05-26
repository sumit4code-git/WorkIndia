package com.example.workexperimentfetch.taskExperiment.worksTasks.remote

import com.google.gson.annotations.SerializedName

data class ExperimentDto(
    val fact: String,
    val experimentName: String,
    @SerializedName("is_enabled")
    val isEnabled: String,
    @SerializedName("experiment_value")
    val experimentValue: List<String>,
)