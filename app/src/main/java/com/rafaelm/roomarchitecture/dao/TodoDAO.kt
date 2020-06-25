package com.rafaelm.roomarchitecture.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.rafaelm.roomarchitecture.entity.Todo

@Dao
interface TodoDAO {

    @Insert
    fun insertTodoData(todo: Todo)

    @Query("Select * from todo_table order by task_id asc")
    fun getAllTodo(): LiveData<List<Todo>>

    @Delete
    fun deleteTodoData(todo: Todo)
}