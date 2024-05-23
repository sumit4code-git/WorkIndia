package com.example.workexperimentfetch.taskExperiment.Workindia

sealed class Response<out T> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Failure(val exception: Throwable) : Response<Nothing>()
}