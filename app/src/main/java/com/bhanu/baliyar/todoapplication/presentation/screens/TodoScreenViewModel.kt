package com.bhanu.baliyar.todoapplication.presentation.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.bhanu.baliyar.todoapplication.data.TodoRepository

class TodoScreenViewModel(private val repository: TodoRepository) : ViewModel() {

//    private val _todoItems = mutableStateListOf(
//            TodoItem(id = 1, title = "Sleep", isCompleted = false),
//            TodoItem(id = 2, title = "Walk", isCompleted = false)
//        )

    private val _todoItems = mutableStateListOf<TodoItem>().apply {
        addAll(repository.getTodos())
    }
    val todoItems = _todoItems


    fun updateTodoItems(id : Int, isCompleted: Boolean){
        val itemId = _todoItems.indexOfFirst { it.id == id }
        if(itemId != -1){
            _todoItems[itemId] = _todoItems[itemId].copy(isCompleted = isCompleted)
        }
    }
}