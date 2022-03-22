package com.apps.fullcourseandroidclassb.todolistapi.db

data class TodoData(
    val completed: Boolean, //checkbox
    val id: Int,
    val title: String, // todo title
    val userId: Int
)