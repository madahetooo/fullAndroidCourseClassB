package com.apps.fullcourseandroidclassb.shoppinglist.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.DialogAddShoppingItemBinding
import com.apps.fullcourseandroidclassb.shoppinglist.model.ShoppingItem

class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    private lateinit var binding: DialogAddShoppingItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.tvAddShoppingItemAdd.setOnClickListener {
            val shoppingItemName = binding.etAddShoppingItemName.text.toString()
            val shoppingItemAmount =binding.etAddShoppingItemAmount.text.toString()
            if (shoppingItemName.isEmpty() || shoppingItemAmount.isEmpty()){
                Toast.makeText(context,"Please enter information",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
           var newItem = ShoppingItem(shoppingItemName,shoppingItemAmount.toInt())
            addDialogListener.onAddButtonClicked(newItem)
            dismiss()
        }


        binding.tvAddShoppingItemCancel.setOnClickListener {
            cancel()
        }

    }
}