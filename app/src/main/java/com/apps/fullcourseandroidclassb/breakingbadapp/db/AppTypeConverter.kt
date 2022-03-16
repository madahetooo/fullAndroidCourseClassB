package com.apps.fullcourseandroidclassb.breakingbadapp.db

import androidx.room.TypeConverter

object AppTypeConverter {
    @TypeConverter
    @JvmStatic
    fun arrayStringToString(value:Array<String>?):String?{
        return value?.joinToString (", ")
    }
    @TypeConverter
    @JvmStatic
    fun stringToArrayString(value:String?):Array<String>?{
        return value?.split("|")?.toTypedArray()
    }
}