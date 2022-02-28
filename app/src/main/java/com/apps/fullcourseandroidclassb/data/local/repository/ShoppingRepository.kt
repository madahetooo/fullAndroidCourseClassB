package com.apps.fullcourseandroidclassb.data.local.repository

import com.apps.fullcourseandroidclassb.data.local.db.ShoppingDatabase
import com.apps.fullcourseandroidclassb.data.local.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}