package com.apps.fullcourseandroidclassb.otherapps.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ActivityNotificationExampleBinding

@Suppress("DEPRECATION")
class NotificationExample : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationExampleBinding
    val CHANNEL_ID = "redBullEventChannelID"
    val CHANNEL_NAME = "redBullEventChannelName"
    val NOTIFICATION_ID = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationExampleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        createNotificationChannel()

        val intent = Intent(this, NotificationExample::class.java)

        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val redBullEventNotification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("RED BULL EVENT")
            .setContentText("You are invited to our RED BULL Event, Here is your ticket")
            .setSmallIcon(R.drawable.notification_lcon)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        binding.btnShowNotification.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, redBullEventNotification)
        }


    }

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.RED
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

}