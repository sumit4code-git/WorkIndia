package com.example.workexperimentfetch.taskExperiment.worksTasks.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.workexperimentfetch.R

class NotificationService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Action.START.name -> startNotService()
            Action.STOP.name -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startNotService() {
        val notification = NotificationCompat.Builder(this, "test_notification")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Testing Service")
            .setContentText("Testing sub title")
            .build()
        startForeground(1, notification)
    }

    enum class Action {
        START, STOP
    }


}