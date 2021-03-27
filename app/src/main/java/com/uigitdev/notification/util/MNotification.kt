package com.uigitdev.notification.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.uigitdev.notification.MainActivity
import com.uigitdev.notification.R


class MNotification(private val context: Context) {

    enum class NOTIFICATION_CHANNEL_ID {
        NC_NOTI_1
    }

    fun notificationReminder() {
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val openIntent = Intent(context, MainActivity::class.java)
        val pendingOpenIntent = PendingIntent.getActivity(context, 1, openIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID.NC_NOTI_1.toString())
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("Title")
                .setContentText("Content")
                .setAutoCancel(true)
                .setShowWhen(true)
                .setOngoing(true)
                .addAction(0, "Action", pendingOpenIntent)
                .setColor(ContextCompat.getColor(context, R.color.purple_200))
                .setStyle(NotificationCompat.BigTextStyle())
                .setContentIntent(pendingIntent)
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(context.packageName)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(context.packageName, context.getString(R.string.app_name), NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(2, builder.build())
    }
}