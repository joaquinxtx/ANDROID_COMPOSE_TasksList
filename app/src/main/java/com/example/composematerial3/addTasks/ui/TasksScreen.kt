package com.example.composematerial3.addTasks.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.composematerial3.addTasks.ui.components.AddTasksDialog
import com.example.composematerial3.addTasks.ui.components.FabDialog


@Composable
fun TasksScreen(tasksViewModel: TasksViewModel, index: Boolean) {
    val showDialog: Boolean by tasksViewModel.showDialog.observeAsState(false)
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val uiState by produceState<TasksUiState>(
        initialValue = TasksUiState.Loading,
        key1 = lifecycle,
        key2 = tasksViewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED){
            tasksViewModel.uiState.collect{value = it}
        }
    }
    when(uiState){
        is TasksUiState.Error -> {

        }
        TasksUiState.Loading -> {
            CircularProgressIndicator()
        }
        is TasksUiState.Success -> {
            AnimatedVisibility(
                visible = index,
                enter = expandHorizontally { 20 },
                exit = shrinkHorizontally(
                    animationSpec = tween(),
                    shrinkTowards = Alignment.End,
                ) { fullWidth ->
                    fullWidth / 4
                }

            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF5F5F5))
                ) {
                    TasksList((uiState as TasksUiState.Success).tasks , tasksViewModel)
                    AddTasksDialog(
                        show = showDialog,
                        onDismiss = { tasksViewModel.onDialogClose() },
                        onTaskAdded = {
                            tasksViewModel.onTaskCreated(it)
                        })
                    FabDialog(
                        Modifier
                            .align(Alignment.BottomEnd)
                            .padding(bottom = 90.dp, end = 10.dp), tasksViewModel
                    )
                }

            }
        }
    }



}







