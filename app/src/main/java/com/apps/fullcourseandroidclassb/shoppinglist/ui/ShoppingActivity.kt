package com.apps.fullcourseandroidclassb.shoppinglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ActivityShoppingBinding
import com.apps.fullcourseandroidclassb.shoppinglist.ui.utils.ShoppingItemAdapter
import com.apps.fullcourseandroidclassb.shoppinglist.db.ShoppingDatabase
import com.apps.fullcourseandroidclassb.shoppinglist.model.ShoppingItem
import com.apps.fullcourseandroidclassb.shoppinglist.repository.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val shoppingItemAdapter = ShoppingItemAdapter(listOf(),viewModel)
        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = shoppingItemAdapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            shoppingItemAdapter.items = it
            shoppingItemAdapter.notifyDataSetChanged()
        })

        binding.fabAddShoppingItem.setOnClickListener {
            AddShoppingItemDialog(this,
            object :AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }


    }
}