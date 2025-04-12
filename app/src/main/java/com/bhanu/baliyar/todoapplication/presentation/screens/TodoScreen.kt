package com.bhanu.baliyar.todoapplication.presentation.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

data class TodoItem(val id: Int, val title: String, val isCompleted: Boolean)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(viewModel: TodoScreenViewModel = hiltViewModel()) {
//    val todoItems = remember {
//        mutableStateListOf<TodoItem>(
//            TodoItem(id = 1, title = "Sleep", isCompleted = false),
//            TodoItem(id = 2, title = "Walk", isCompleted = true)
//        )
//    }

    val todoItems = viewModel.todoItems
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ToDO Application") }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {

                items(todoItems) { item ->
                    TodoItem(todo = item, onCheckedChange = { value ->
                      viewModel.updateTodo(item.id, value)
                    })
//                    TodoItem(todo = item, onCheckedChange = { value ->
//                        val index = todoItems.indexOfFirst { it.id == item.id }
//                        if (index != -1) {
//                            todoItems[index] = todoItems[index].copy(isCompleted = value)
//                        }
//                    })
                }
            }
        }

    )
}

@Composable
fun TodoItem(todo: TodoItem, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        Checkbox(
            checked = todo.isCompleted,
            onCheckedChange = onCheckedChange
        )
        Text(text = todo.title)
    }

}