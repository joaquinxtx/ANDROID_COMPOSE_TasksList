package com.example.composematerial3.presentation.screens.addTasks.components

import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composematerial3.domain.Resource
import com.example.composematerial3.presentation.screens.addTasks.TasksViewModel

@Composable
fun DeleteTask(
    vm: TasksViewModel = hiltViewModel(),
) {
    when (val response = vm.deleteTaskResponse) {
        Resource.Loading -> {
            Text(text = "Cargando")
        }
        is Resource.Success -> {
            Toast.makeText(
                LocalContext.current,
                "Categoria eliminada correcatamente",
                Toast.LENGTH_SHORT
            )
                .show()
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