package com.example.composematerial3.presentation.screens.addTasks.components

import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.example.composematerial3.domain.Resource
import com.example.composematerial3.domain.model.TaskModel
import com.example.composematerial3.presentation.screens.addTasks.TasksUiState
import com.example.composematerial3.presentation.screens.addTasks.TasksViewModel

@Composable
fun GetTask(
    vm: TasksViewModel = hiltViewModel(),


    ) {
    when (val response = vm.taskResponse) {
        Resource.Loading -> {

            CircularProgressIndicator()
        }

        is Resource.Success -> {
            TasksList(tasks = response.data!!)

        }
        is Resource.Failure -> {

            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT)
                .show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error Desconocido", Toast.LENGTH_SHORT).show()

            }
        }
    }
}



