package com.apps.fullcourseandroidclassb

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlaneModeChangedReceiver :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirPlaneModeEnabled = intent?.getBooleanExtra("state",false)?:return
        if (isAirPlaneModeEnabled){
            Toast.makeText(context,"Air Plane Mode is Enabled",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context,"Air Plane Mode is Disabled",Toast.LENGTH_LONG).show()

        }
    }
}