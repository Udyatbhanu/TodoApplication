package com.bhanu.baliyar.todoapplication.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bhanu.baliyar.todoapplication.data.TodoRepository
import com.bhanu.baliyar.todoapplication.presentation.screens.TodoScreenViewModel

class TodoViewModelFactory(
    private val repository: TodoRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TodoScreenViewModel(repository) as T
    }
}