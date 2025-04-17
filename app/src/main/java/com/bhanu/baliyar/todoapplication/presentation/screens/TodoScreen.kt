package com.bhanu.baliyar.todoapplication.presentation.screens

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bhanu.baliyar.todoapplication.core.TodoApplication

data class TodoItem(val id: Int, val todo: String, val isCompleted: Boolean)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen() {

    val context = LocalContext.current.applicationContext as TodoApplication
    val viewModel: TodoViewModel = viewModel(factory = context.container.viewModelFactory)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "TodoApp") }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },

        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                ToDoContent(viewModel = viewModel)
            }
        })

}

@Composable
fun ToDoContent(viewModel: TodoViewModel) {
    val todoItems = viewModel.state
    LazyColumn {
        items(todoItems) { item ->
            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = item.isCompleted, onCheckedChange = { checked ->
                    viewModel.updateTodos(id = item.id, checked = checked)
                })
                Text(text = item.todo)
            }
        }
    }
}


