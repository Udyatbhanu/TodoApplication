package com.bhanu.baliyar.todoapplication.data

class AppContainer {
    val todoRepository: TodoRepository by lazy {
        TodoRepository() // Could take other deps later
    }
}