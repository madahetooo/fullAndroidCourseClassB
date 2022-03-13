package com.apps.fullcourseandroidclassb

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullcourseandroidclassb.data.local.db.NotificationData
import com.apps.fullcourseandroidclassb.data.local.db.PushNotification
import com.apps.fullcourseandroidclassb.data.local.db.RetrofitInstance
import com.apps.fullcourseandroidclassb.utils.FirebaseService
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_cloud_messaging_app.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
const val TOPIC = "/topics/myTopic"
class CloudMessagingApp : AppCompatActivity() {
    val TAG = "CloudMessagingApp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cloud_messaging_app)
        FirebaseService.sharedPref = getSharedPreferences("sharedPrefFile", Context.MODE_PRIVATE)
        FirebaseMessaging.getInstance().token.addOnSuccessListener {
            FirebaseService.token = it
            etNotificationToken.setText(it)
        }

        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)

        btnSendNotification.setOnClickListener {
            val notificationTitle = etNotificationTitle.text.toString()
            val notificationMessage = etNotificationMessage.text.toString()
            val recipientToken = etNotificationToken.text.toString()
            if (notificationTitle.isNotEmpty() && notificationMessage.isNotEmpty()){
                PushNotification(NotificationData(notificationTitle,notificationMessage), recipientToken).also {
                    sendNotification(it)
                }
            }
        }
    }

    private fun sendNotification(notification: PushNotification) =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.postNotification(notification)
                if (response.isSuccessful) {
                    Log.d(TAG, "${Gson().toJson(response)}")
                } else {
                    Log.d(TAG, response.errorBody().toString())
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@CloudMessagingApp, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
}