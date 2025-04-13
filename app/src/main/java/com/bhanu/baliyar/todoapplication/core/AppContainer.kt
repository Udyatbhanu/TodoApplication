package com.bhanu.baliyar.todoapplication.core

import com.bhanu.baliyar.todoapplication.data.TodoRepository
import com.bhanu.baliyar.todoapplication.presentation.screens.TodoViewModel

class AppContainer {

    val todoRepository by lazy {
        TodoRepository()
    }

    val viewModelFactory: VMFactory by lazy {
        VMFactory(
            mapOf(TodoViewModel::class.java to { TodoViewModel(todoRepository = todoRepository) })
        )
    }
}