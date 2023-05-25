package com.example.composematerial3.addTasks.ui

import com.example.composematerial3.addTasks.ui.model.TaskModel

sealed interface TasksUiState{
    object Loading:TasksUiState
    data class Error(val throwable: Throwable):TasksUiState
    data class Success(val tasks:List<TaskModel>):TasksUiState
}