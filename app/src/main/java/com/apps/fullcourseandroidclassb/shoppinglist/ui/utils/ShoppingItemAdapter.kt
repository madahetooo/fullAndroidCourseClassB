package com.apps.fullcourseandroidclassb.shoppinglist.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullcourseandroidclassb.shoppinglist.model.ShoppingItem
import com.apps.fullcourseandroidclassb.databinding.ShoppingItemBinding
import com.apps.fullcourseandroidclassb.shoppinglist.ui.ShoppingViewModel


class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    inner class ShoppingViewHolder(val binding: ShoppingItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(ShoppingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        var currentShoppingItem = items[position]
        holder.binding.tvShoppingItemsName.text = currentShoppingItem.name
        holder.binding.tvShoppingItemsAmount.text = "${currentShoppingItem.amount}"
        holder.binding.ivShoppingItemsDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
        holder.binding.ivShoppingItemsAdd.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }
        holder.binding.ivShoppingItemsMinus.setOnClickListener {
            if (currentShoppingItem.amount > 0) {
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }

        }


    }

    override fun getItemCount(): Int {
        return items.size
    }
}