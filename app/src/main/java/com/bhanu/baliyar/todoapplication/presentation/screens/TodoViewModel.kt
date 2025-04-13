package com.bhanu.baliyar.todoapplication.presentation.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.bhanu.baliyar.todoapplication.data.TodoRepository

class TodoViewModel(private val todoRepository: TodoRepository) : ViewModel() {


    private val _state = mutableStateListOf<TodoItem>().apply {
        addAll(todoRepository.getTodos())
    }

    val state = _state

    fun updateTodos(id : Int, checked : Boolean){
        val itemId = _state.indexOfFirst { id == it.id }
        if (itemId != -1) {
            _state[itemId] = _state[itemId].copy(isCompleted = checked)
        }
    }
}