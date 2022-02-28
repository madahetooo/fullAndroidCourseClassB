package com.apps.fullcourseandroidclassb.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.apps.fullcourseandroidclassb.data.local.db.entities.ShoppingItem
import com.apps.fullcourseandroidclassb.data.local.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel() {

    fun upsert(item:ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun getAllShoppingItems() = repository.getAllShoppingItems()
}