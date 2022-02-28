package com.apps.fullcourseandroidclassb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.data.local.db.entities.ShoppingItem
import com.apps.fullcourseandroidclassb.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)

    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        var currentShoppingItem = items[position]
        holder.itemView.tvShoppingItemsName.text = currentShoppingItem.name
        holder.itemView.tvShoppingItemsAmount.text = "${currentShoppingItem.amount}"
        holder.itemView.ivShoppingItemsDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
        holder.itemView.ivShoppingItemsAdd.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }
        holder.itemView.ivShoppingItemsMinus.setOnClickListener {
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