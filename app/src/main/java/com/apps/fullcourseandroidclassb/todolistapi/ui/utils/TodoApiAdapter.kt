package com.apps.fullcourseandroidclassb.todolistapi.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullcourseandroidclassb.databinding.ItemTodoApiBinding
import com.apps.fullcourseandroidclassb.todolistapi.db.TodoData

class TodoApiAdapter : RecyclerView.Adapter<TodoApiAdapter.TodoApiViewHolder>() {

    inner class TodoApiViewHolder(val binding: ItemTodoApiBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<TodoData>() {
        override fun areItemsTheSame(oldItem: TodoData, newItem: TodoData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TodoData, newItem: TodoData): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this,diffCallback)
    var todos:List<TodoData>
    get() = differ.currentList
    set(value){
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoApiViewHolder {
        return TodoApiViewHolder(ItemTodoApiBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoApiViewHolder, position: Int) {
        holder.binding.apply {
            val singleTodo = todos[position]
            tvTodoTitleApi.text = singleTodo.title
            cbTodoApiDone.isChecked = singleTodo.completed
        }
    }

    override fun getItemCount() = todos.size
}