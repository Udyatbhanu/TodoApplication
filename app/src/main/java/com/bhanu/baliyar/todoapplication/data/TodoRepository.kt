package com.bhanu.baliyar.todoapplication.data

import com.bhanu.baliyar.todoapplication.presentation.screens.TodoItem

class TodoRepository {

    fun getTodos() = listOf<TodoItem>(
        TodoItem(id = 1, todo = "Walk", isCompleted = false),
        TodoItem(id = 2, todo = "Eat", isCompleted = false)
    )
}