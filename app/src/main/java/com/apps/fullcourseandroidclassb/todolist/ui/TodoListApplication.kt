package com.apps.fullcourseandroidclassb.todolist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.fullcourseandroidclassb.databinding.ActivityTodoListApplicationBinding
import com.apps.fullcourseandroidclassb.todolist.model.Todo
import com.apps.fullcourseandroidclassb.todolist.ui.utils.TodoAdapter

class TodoListApplication : Fragment() {
    private var _binding: ActivityTodoListApplicationBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityTodoListApplicationBinding.inflate(inflater, container, false)
        val view = binding.root
        var todoList = mutableListOf(
            Todo("Todo Number 1 ", false),
            Todo("Todo Number 2 ", false),
            Todo("Todo Number 3 ", false),
            Todo("Todo Number 4 ", false),
//            Todo("Todo Number 5 ", false),
//            Todo("Todo Number 6 ", false),
//            Todo("Todo Number 7 ", false),
//            Todo("Todo Number 8 ", false),
//            Todo("Todo Number 9 ", false),
//            Todo("Todo Number 10 ", false),
//            Todo("Todo Number 11", false),
//            Todo("Todo Number 12 ", false),
//            Todo("Todo Number 13 ", false),
//            Todo("Todo Number 14 ", false),
//            Todo("Todo Number 15 ", false),
        )
        val ourAdapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = ourAdapter
        binding.rvTodos?.layoutManager = LinearLayoutManager(activity)

        binding.btnAddTodo.setOnClickListener {
            val newTodoTitle = binding.etTodo.text.toString()
            val newTodo = Todo(newTodoTitle, false)
            todoList.add(newTodo)
            ourAdapter.notifyItemInserted(todoList.size - 1)
            binding.etTodo.text.clear()
        }
        return view

    }
}