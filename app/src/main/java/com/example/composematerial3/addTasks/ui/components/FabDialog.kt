package com.example.composematerial3.addTasks.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composematerial3.addTasks.ui.TasksViewModel

@Composable
fun FabDialog(modifier: Modifier, tasksViewModel: TasksViewModel) {

    FloatingActionButton(onClick = {
        tasksViewModel.onShowDialogClick()
    }, modifier = modifier, containerColor = Color(0xFFFF5722) , contentColor = Color.White) {
        Icon(Icons.Filled.Add, contentDescription = "")
    }
}