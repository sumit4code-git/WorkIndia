package com.example.workexperimentfetch.taskExperiment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication:Application()  {
    companion object {
        @JvmStatic
        lateinit var instance: MyApplication
    }
}