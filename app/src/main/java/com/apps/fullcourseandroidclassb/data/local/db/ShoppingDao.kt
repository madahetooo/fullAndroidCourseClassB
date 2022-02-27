package com.apps.fullcourseandroidclassb.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.apps.fullcourseandroidclassb.data.local.db.entities.ShoppingItem

@Dao
 interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}