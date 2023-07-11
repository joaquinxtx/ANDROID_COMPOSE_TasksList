package com.example.composematerial3.presentation.screens.addTasks.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composematerial3.presentation.screens.addTasks.TasksViewModel

@Composable
fun FabDialog(modifier: Modifier, tasksViewModel: TasksViewModel = hiltViewModel()) {

    FloatingActionButton(onClick = {
        tasksViewModel.onShowDialogClick()
    }, modifier = modifier, containerColor = Color(0xFF00BD61), contentColor = Color.White) {
        Icon(Icons.Filled.Add, contentDescription = "")
    }
}