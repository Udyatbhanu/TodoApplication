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
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bhanu.baliyar.todoapplication.core.TodoApplication
import com.bhanu.baliyar.todoapplication.core.TodoViewModelFactory


data class TodoItem(val id: Int, val title: String, val isCompleted: Boolean)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen() {
    val context = LocalContext.current.applicationContext as TodoApplication
    val factory = remember {
        TodoViewModelFactory(context.container.todoRepository)
    }
    val viewModel: TodoScreenViewModel = viewModel(factory = factory)

    val todoItems = viewModel.todoItems
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Todo App") }, colors = TopAppBarDefaults.topAppBarColors(
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
                    .padding(8.dp)
            ) {
                items(todoItems) { todo ->
                    TodoRow(todo, onCheckedChange = { value ->
                        viewModel.updateTodoItems(id = todo.id, isCompleted = value)
                    })
                }
            }
        }
    )
}


@Composable
fun TodoRow(todo: TodoItem, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
        Checkbox(checked = todo.isCompleted, onCheckedChange = onCheckedChange)
        Text(text = todo.title)
    }

}