package com.apps.fullcourseandroidclassb.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.data.local.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAddShoppingItemAdd.setOnClickListener {
            val shoppingItemName = etAddShoppingItemName.text.toString()
            val shoppingItemAmount = etAddShoppingItemAmount.text.toString()
            if (shoppingItemName.isEmpty() || shoppingItemAmount.isEmpty()){
                Toast.makeText(context,"Please enter information",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
           var newItem = ShoppingItem(shoppingItemName,shoppingItemAmount.toInt())
            addDialogListener.onAddButtonClicked(newItem)
            dismiss()
        }


        tvAddShoppingItemCancel.setOnClickListener {
            cancel()
        }

    }
}