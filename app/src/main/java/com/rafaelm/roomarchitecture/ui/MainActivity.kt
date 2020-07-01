package com.rafaelm.roomarchitecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rafaelm.roomarchitecture.R
import com.rafaelm.roomarchitecture.entity.Todo

class MainActivity : AppCompatActivity() {

    private lateinit var todoViewModel: TodoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)

        todoViewModel.insertTodo(getTodoData())

        todoViewModel.getTodoList()?.observe(this, Observer {
            Log.i("MainActivity", it.toString())
        })
    }

    private fun getTodoData(): Todo{
        return Todo(taskName = "First Task", taskDescription = "Do it Now!")
    }
}