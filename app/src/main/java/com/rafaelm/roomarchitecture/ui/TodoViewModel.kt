package com.rafaelm.roomarchitecture.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.rafaelm.roomarchitecture.entity.Todo

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: TodoRepository = TodoRepository(application)

    fun getTodoList() = repository.getTodoList()

    fun insertTodo(todo: Todo) {
        repository.insertTodo(todo)
    }

    fun deleteTodo(todo: Todo) {
        repository.deleteTodo(todo)
    }
}