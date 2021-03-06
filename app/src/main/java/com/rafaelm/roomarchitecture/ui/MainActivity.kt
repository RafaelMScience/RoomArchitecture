package com.rafaelm.roomarchitecture.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rafaelm.roomarchitecture.R
import com.rafaelm.roomarchitecture.entity.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TodoDialog.TodoDialogListener {

    private lateinit var todoViewModel: TodoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFab.setOnClickListener {
            todoInsertDialog()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.todoRecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)

        todoViewModel.getTodoList()?.observe(this, Observer {
            Log.i("MainActivity", it.toString())
            val adapter = TodoAdapter(it)
            recyclerView.adapter = adapter
        })
    }

    private fun todoInsertDialog() {
        TodoDialog().show(supportFragmentManager, "todo_dialog")
    }

    override fun getTodoData(taskName: String?, taskDescription: String?) {
        if (taskName != null && taskDescription != null) {
            val todo = Todo(taskName = taskName, taskDescription = taskDescription)
            todoViewModel.insertTodo(todo)
        }
    }
}