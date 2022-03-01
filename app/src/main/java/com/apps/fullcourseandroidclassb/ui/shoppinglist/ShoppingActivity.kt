package com.apps.fullcourseandroidclassb.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.adapters.ShoppingItemAdapter
import com.apps.fullcourseandroidclassb.data.local.db.ShoppingDatabase
import com.apps.fullcourseandroidclassb.data.local.db.entities.ShoppingItem
import com.apps.fullcourseandroidclassb.data.local.repository.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)


        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val shoppingItemAdapter = ShoppingItemAdapter(listOf(),viewModel)
        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = shoppingItemAdapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            shoppingItemAdapter.items = it
            shoppingItemAdapter.notifyDataSetChanged()
        })

        fabAddShoppingItem.setOnClickListener {
            AddShoppingItemDialog(this,
            object :AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }


    }
}