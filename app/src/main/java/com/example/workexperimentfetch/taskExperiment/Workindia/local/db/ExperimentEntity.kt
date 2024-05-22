package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("experiment_table")
data class ExperimentEntity(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    @ColumnInfo("experiment_name")
    val experimentName: String,
    @ColumnInfo("experiment_value")
    val experimentValue: List<String>,
    @ColumnInfo("lastCached")
    val lastCached: Long,
)