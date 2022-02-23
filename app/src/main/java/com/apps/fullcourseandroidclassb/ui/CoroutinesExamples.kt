package com.apps.fullcourseandroidclassb.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullcourseandroidclassb.R
import kotlinx.android.synthetic.main.activity_coroutines_examples.*
import kotlinx.coroutines.*

class CoroutinesExamples : AppCompatActivity() {

    val TAG = "CoroutinesExamples"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_examples)
        GlobalScope.launch(Dispatchers.IO) {
            //COROUTINE THREAD
            val updatedText = doNetworkCall() //
            withContext(Dispatchers.Main){
                //I CAN ONLY UPDATE UI IN MAIN THREAD ONLYYYYYYYYY
                tvDummy.text = updatedText
            }
        }
        //MAIN THREAD
        Log.d(TAG, "Hello from thread ${Thread.currentThread().name}")
    }

    suspend fun doNetworkCall(): String {
        delay(5000)
        return "This is new text"
    }
}