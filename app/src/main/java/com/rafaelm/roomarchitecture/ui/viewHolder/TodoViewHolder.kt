package com.rafaelm.roomarchitecture.ui.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rafaelm.roomarchitecture.R
import com.rafaelm.roomarchitecture.entity.Todo

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItems(todo: Todo) {
        val textViewTaskName = itemView.findViewById<TextView>(R.id.taskName)
        val textViewDescription = itemView.findViewById<TextView>(R.id.taskDescription)

        textViewTaskName.text = todo.taskName
        textViewDescription.text = todo.taskDescription
    }
}