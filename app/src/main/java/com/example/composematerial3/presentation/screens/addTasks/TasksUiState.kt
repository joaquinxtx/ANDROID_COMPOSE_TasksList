package com.example.composematerial3.presentation.screens.addTasks

import com.example.composematerial3.domain.Resource
import com.example.composematerial3.domain.model.TaskModel

sealed interface TasksUiState{
    object Loading: TasksUiState
    data class Error(val throwable: Throwable): TasksUiState
    data class Success(val tasks: Resource<List<TaskModel>>): TasksUiState
}