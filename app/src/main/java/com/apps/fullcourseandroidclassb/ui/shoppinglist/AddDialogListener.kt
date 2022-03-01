package com.apps.fullcourseandroidclassb.ui.shoppinglist

import com.apps.fullcourseandroidclassb.data.local.db.entities.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)
}