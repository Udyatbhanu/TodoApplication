package com.bhanu.baliyar.todoapplication.core

import com.bhanu.baliyar.todoapplication.data.TodoRepository

class AppContainer {
    val todoRepository: TodoRepository by lazy {
        TodoRepository() // Could take other deps later
    }
}