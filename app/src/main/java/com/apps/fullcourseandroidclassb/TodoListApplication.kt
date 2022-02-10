package com.apps.fullcourseandroidclassb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_todo_list_application.*

class TodoListApplication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list_application)
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
        rvTodos.adapter = ourAdapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val newTodoTitle = etTodo.text.toString()
            val newTodo = Todo(newTodoTitle, false)
            todoList.add(newTodo)
            ourAdapter.notifyItemInserted(todoList.size-1)
            etTodo.text.clear()
        }
    }
}