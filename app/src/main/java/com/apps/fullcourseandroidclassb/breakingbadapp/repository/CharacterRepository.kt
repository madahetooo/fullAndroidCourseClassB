package com.apps.fullcourseandroidclassb.breakingbadapp.repository

import androidx.lifecycle.LiveData
import com.apps.fullcourseandroidclassb.breakingbadapp.db.CharacterDao
import com.apps.fullcourseandroidclassb.breakingbadapp.model.BBCharacter
import com.apps.fullcourseandroidclassb.breakingbadapp.service.BreakingBadNetwork
import com.apps.fullcourseandroidclassb.breakingbadapp.service.BreakingBadService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterRepository(private val characterDao: CharacterDao) {

    var characters:LiveData<List<BBCharacter>> = characterDao.findAllCharacters()

   suspend fun refreshCharacter(){
       withContext(Dispatchers.IO){
           val characters = BreakingBadNetwork.serviceApi.getCharacters() //GETTING ALL DATA
           characterDao.insertAllCharacters(characters) //INSERT DATA TO DATABASE
       }
   }
}