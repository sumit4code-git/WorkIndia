package com.example.workexperimentfetch.taskExperiment.worksTasks

sealed class Resource<T> {
    class Success<T>(val data: T) : Resource<T>()
    class Error<T>(val message: String, val code: Int = 400) : Resource<T>()
    class Loading<T> : Resource<T>()
    class Empty<T> : Resource<T>()
}