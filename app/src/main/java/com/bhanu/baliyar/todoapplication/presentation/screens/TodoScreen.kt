package com.bhanu.baliyar.todoapplication.presentation.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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

data class TodoItem(val id: Int, val title: String, val isCompleted: Boolean)

val todoItems = listOf<TodoItem>(
    TodoItem(id = 1, title = "Sleep", isCompleted = false),
    TodoItem(id = 2, title = "Walk", isCompleted = false)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen() {

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
                    TodoItem(todo = item)
                }
            }
        }

    )
}

@Composable
fun TodoItem(todo: TodoItem) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = { },

            )
        Text(text = todo.title)
    }

}