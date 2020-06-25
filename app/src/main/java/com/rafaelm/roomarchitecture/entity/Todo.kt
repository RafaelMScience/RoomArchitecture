package com.rafaelm.roomarchitecture.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    var taskId: Int = 0,

    @ColumnInfo(name = "task_name")
    var taskName: String,

    @ColumnInfo(name = "task_description")
    var taskDescription: String
)