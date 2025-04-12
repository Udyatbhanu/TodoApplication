package com.bhanu.baliyar.todoapplication.presentation.screens

import android.view.View
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoScreenViewModel @Inject constructor() : ViewModel() {

    private val _todoItems = mutableStateListOf<TodoItem>(
        TodoItem(id = 1, title = "Sleep", isCompleted = false),
        TodoItem(id = 2, title = "Walk", isCompleted = true)
    )

    val todoItems: List<TodoItem> = _todoItems

    fun updateTodo(id: Int, isCompleted: Boolean) {
        val index = _todoItems.indexOfFirst { it.id == id }
        if (index != -1) {
            _todoItems[index] = _todoItems[index].copy(isCompleted = isCompleted)
        }
    }

}