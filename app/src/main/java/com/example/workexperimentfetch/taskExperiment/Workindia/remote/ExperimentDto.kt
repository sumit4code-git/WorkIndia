package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote

import com.google.gson.annotations.SerializedName

data class ExperimentDto(
    @SerializedName("experiment_name")
    val experimentName: String,
    @SerializedName("is_enabled")
    val isEnabled: String,
    @SerializedName("experiment_value")
    val experimentValue: List<String>,
)