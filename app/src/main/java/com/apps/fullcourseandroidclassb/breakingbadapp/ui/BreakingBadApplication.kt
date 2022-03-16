package com.apps.fullcourseandroidclassb.breakingbadapp.ui

import android.app.Application
import com.apps.fullcourseandroidclassb.breakingbadapp.db.CharacterDatabase
import com.apps.fullcourseandroidclassb.breakingbadapp.repository.CharacterRepository

class BreakingBadApplication : Application() {

    val database by lazy {
        CharacterDatabase.createDatabase(this)
    }
    val characterRepository by lazy {
        CharacterRepository(database.createCharacterDao())
    }
}