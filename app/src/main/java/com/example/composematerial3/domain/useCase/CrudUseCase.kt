package com.example.composematerial3.domain.useCase

data class CrudUseCase(
    val addTask: AddTaskUseCase,
    val getTasks: GetTasksUseCase,
    val updateTask: UpdateTaskUseCase,
    val deleteTask: DeleteTaskUseCase
)
