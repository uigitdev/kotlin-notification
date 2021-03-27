package com.uigitdev.notification

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.uigitdev.notification.util.MNotification

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.item_button)
        button.setOnClickListener {
            MNotification(this).notificationReminder()
        }
    }
}