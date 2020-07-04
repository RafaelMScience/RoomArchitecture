package com.rafaelm.roomarchitecture.ui

import android.app.ActivityManager
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import com.rafaelm.roomarchitecture.R
import java.lang.ClassCastException

class TodoDialog : AppCompatDialogFragment() {
    private var editTextTaskName: EditText? = null
    private var editTextTaskDescription: EditText? = null
    private var listener: TodoDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder: AlertDialog.Builder = AlertDialog.Builder(activity)

        var inflater = activity!!.layoutInflater
        var view: View = inflater.inflate(R.layout.todo_dialog, null)

        editTextTaskName = view.findViewById(R.id.taskName)
        editTextTaskDescription = view.findViewById(R.id.taskDescription)

        builder.setView(view)
            .setNegativeButton("Cancel") { _, _ -> dismiss() }
            .setPositiveButton("Ok") { _, _ ->
                val taskName = editTextTaskName!!.text.toString()
                val taskDescription = editTextTaskDescription!!.text.toString()

                listener!!.getTodoData(taskName,taskDescription)
            }

        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            context as TodoDialogListener
        }catch (e: ClassCastException){
            throw  ClassCastException(
                context.toString() + "must implement TodoDialog"
            )
        }
    }

    interface  TodoDialogListener{
        fun getTodoData(taskName: String?, taskDescription: String?)
    }
}