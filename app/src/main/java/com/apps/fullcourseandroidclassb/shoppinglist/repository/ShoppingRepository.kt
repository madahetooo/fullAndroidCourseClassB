package com.apps.fullcourseandroidclassb.shoppinglist.repository

import com.apps.fullcourseandroidclassb.shoppinglist.db.ShoppingDatabase
import com.apps.fullcourseandroidclassb.shoppinglist.model.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}