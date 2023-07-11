package com.example.composematerial3.presentation.screens.addTasks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composematerial3.presentation.screens.addTasks.TasksViewModel
import com.example.composematerial3.presentation.screens.addTasks.mapper.toTask


@Composable
fun ContentTask(vm: TasksViewModel = hiltViewModel()) {
    val showDialog: Boolean by vm.showDialog.observeAsState(false)
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        GetTask()

        AddTasksDialog(
            show = showDialog,
            onDismiss = {
                vm.onDialogClose()
            }, vm = vm
        )
        FabDialog(
            Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 90.dp, end = 10.dp)
        )
    }
    DeleteTask()

}

