package com.rafaelm.roomarchitecture.ui

import android.app.Application
import com.rafaelm.roomarchitecture.dao.TodoDAO
import com.rafaelm.roomarchitecture.database.TodoDatabase
import com.rafaelm.roomarchitecture.entity.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class TodoRepository(application: Application) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var todoDAO: TodoDAO?

    init {
        val db = TodoDatabase.getInstance(application)
        todoDAO = db.todoDao
    }

    fun getTodoList() = todoDAO?.getAllTodo()

    fun insertTodo(todo: Todo) {
        launch {
            insert(todo)
        }
    }

    fun deleteTodo(todo: Todo){
        launch {
            delete(todo)
        }
    }

    private suspend fun insert(todo: Todo) {
        withContext(Dispatchers.IO) {
            todoDAO?.insertTodoData(todo)
        }
    }

    private suspend fun delete(todo: Todo){
        withContext(Dispatchers.IO){
            todoDAO?.deleteTodoData(todo)
        }
    }
}