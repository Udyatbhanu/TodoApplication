package com.bhanu.baliyar.todoapplication.data

import com.bhanu.baliyar.todoapplication.presentation.screens.TodoItem

class TodoRepository {
    fun getTodos(): List<TodoItem> = listOf(
        TodoItem(1, "Sleep", false),
        TodoItem(2, "Walk", true)
    )
}