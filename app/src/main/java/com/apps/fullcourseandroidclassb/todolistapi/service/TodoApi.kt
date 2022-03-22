package com.apps.fullcourseandroidclassb.todolistapi.service

import com.apps.fullcourseandroidclassb.todolistapi.db.TodoData
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {

    @GET("/todos")
   suspend fun getTodos():Response<List<TodoData>>
}