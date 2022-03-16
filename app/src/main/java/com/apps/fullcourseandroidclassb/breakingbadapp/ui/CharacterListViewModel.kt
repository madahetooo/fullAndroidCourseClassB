package com.apps.fullcourseandroidclassb.breakingbadapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.apps.fullcourseandroidclassb.breakingbadapp.repository.CharacterRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CharacterListViewModel (private val characterRepository: CharacterRepository):ViewModel(){

    init {
        refreshDataFromRepository()
    }
    val characters = characterRepository.characters

    fun refreshDataFromRepository(){
        viewModelScope.launch {
            characterRepository.refreshCharacter()
        }
    }

}

@Suppress("UNCHECKED_CAST")
class CharacterListViewModelFactory(private val characterRepository: CharacterRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterListViewModel::class.java)){
            return CharacterListViewModel(characterRepository) as T

        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}