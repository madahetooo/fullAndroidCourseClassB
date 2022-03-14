package com.apps.fullcourseandroidclassb.breakingbadapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.apps.fullcourseandroidclassb.breakingbadapp.model.BBCharacter

@Database(
    entities = [BBCharacter::class],
    version = 1
)
@TypeConverters(AppTypeConverter::class)
abstract class CharacterDatabase :RoomDatabase(){
    abstract fun createCharacterDao():CharacterDao

    companion object{
        @Volatile
        private var INSTANCE:CharacterDatabase?=null

        fun createDatabase(context: Context):CharacterDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CharacterDatabase::class.java,
                    "bbapp.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}