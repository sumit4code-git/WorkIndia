package com.example.workexperimentfetch.taskExperiment.worksTasks.services

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat

@Composable
fun Services(name: String, context: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        ActivityCompat.requestPermissions(
            context,
            arrayOf(Manifest.permission.POST_NOTIFICATIONS), 0
        )
    Column {
        Button(
            onClick = {
                Intent(context, NotificationService::class.java).also {
                    it.action = NotificationService.Action.START.name
                    context.startService(it)
                }
            }
        ) {
            Text(text = "Hello Start service")
        }
        Button(
            onClick = {
                Intent(context, NotificationService::class.java).also {
                    it.action = NotificationService.Action.STOP.name
                    context.startService(it)
                }
            }
        ) {
            Text(text = "Hello Stop service")
        }
    }
}