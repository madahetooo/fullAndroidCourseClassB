package com.apps.fullcourseandroidclassb.shoppinglist.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.apps.fullcourseandroidclassb.shoppinglist.model.ShoppingItem

@Dao
 interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}