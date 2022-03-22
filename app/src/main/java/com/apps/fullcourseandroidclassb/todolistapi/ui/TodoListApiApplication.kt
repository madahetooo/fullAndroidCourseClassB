package com.apps.fullcourseandroidclassb.todolistapi.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.fullcourseandroidclassb.databinding.ActivityTodoListApiApplicationBinding
import com.apps.fullcourseandroidclassb.todolistapi.service.TodoRetrofitInstance
import com.apps.fullcourseandroidclassb.todolistapi.ui.utils.TodoApiAdapter
import retrofit2.HttpException
import java.io.IOException

const val TAG = "TodoListApiApplication"

class TodoListApiApplication : AppCompatActivity() {
    private lateinit var todoApiAdapter: TodoApiAdapter
    private lateinit var binding: ActivityTodoListApiApplicationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListApiApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.progressBarTodoApi.isVisible = true //Show ProgressBar
            val response = try {
                TodoRetrofitInstance.api.getTodos() // GET LIST OF TODOS
            } catch (e: IOException) {
                Log.d(TAG, "IOException, You might  have internet connection issue")
                binding.progressBarTodoApi.isVisible = false //Show ProgressBar
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.d(TAG, "HttpException, Response not successful")
                binding.progressBarTodoApi.isVisible = false //Show ProgressBar
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                todoApiAdapter.todos = response.body()!!
            }
            else{
                Log.d(TAG, "Response not successful")
            }
            binding.progressBarTodoApi.isVisible = false //Show ProgressBar
        }

    }

    private fun setupRecyclerView() = binding.rvTodosApi.apply {
        todoApiAdapter = TodoApiAdapter()
        adapter = todoApiAdapter
        layoutManager = LinearLayoutManager(this@TodoListApiApplication)
    }
}