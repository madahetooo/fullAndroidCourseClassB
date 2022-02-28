package com.apps.fullcourseandroidclassb.utils

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullcourseandroidclassb.R
import kotlinx.coroutines.*

class CoroutinesExamples : AppCompatActivity() {

    val TAG = "CoroutinesExamples"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_examples)

        GlobalScope.launch(Dispatchers.Main) {
           val answer1 = async {
               doNetworkCall1()
           }
           val answer2 = async { doNetworkCall2() }
            Log.d(TAG, "Answer 1 is equal to ${answer1.await()} ")
            Log.d(TAG, "Answer 2 is equal to ${answer2.await()} ")
        }
        runBlocking {
            delay(423L)
        }

    }

    suspend fun doNetworkCall1(): String {
        delay(8000L)
        return "ANSWER 1"
    }
    suspend fun doNetworkCall2(): String {
        delay(8000L)
        return "ANSWER 2"
    }
}










//var answer1: String? = null
//var answer2: String? = null
//val job1 = launch {
//    answer1 = doNetworkCall1()
//}
//val job2 = launch {
//    answer2 = doNetworkCall2()
//}
//job1.join()
//job2.join()
//Log.d(TAG, "Answer 1 is equal to $answer1 ")
//Log.d(TAG, "Answer 2 is equal to $answer2 ")