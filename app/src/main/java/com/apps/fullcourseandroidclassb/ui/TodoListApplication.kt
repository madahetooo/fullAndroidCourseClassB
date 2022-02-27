package com.apps.fullcourseandroidclassb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.adapters.TodoAdapter
import com.apps.fullcourseandroidclassb.data.local.db.entities.Todo
import kotlinx.android.synthetic.main.activity_todo_list_application.view.*

class TodoListApplication : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view =  inflater.inflate(R.layout.activity_todo_list_application, container, false)
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
        view.rvTodos.adapter = ourAdapter
        view.rvTodos?.layoutManager = LinearLayoutManager(activity)

        view.btnAddTodo.setOnClickListener {
            val newTodoTitle = view.etTodo.text.toString()
            val newTodo = Todo(newTodoTitle, false)
            todoList.add(newTodo)
            ourAdapter.notifyItemInserted(todoList.size-1)
            view.etTodo.text.clear()
        }
        return view

    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_todo_list_application)

    }