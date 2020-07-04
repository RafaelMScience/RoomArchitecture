package com.rafaelm.roomarchitecture.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelm.roomarchitecture.R
import com.rafaelm.roomarchitecture.entity.Todo
import com.rafaelm.roomarchitecture.ui.viewHolder.TodoViewHolder

class TodoAdapter(private val todo: List<Todo>) : RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.todo_item_layout, parent, false)
        return TodoViewHolder(v)
    }

    override fun getItemCount(): Int {
        return todo.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bindItems(todo[position])
    }

}