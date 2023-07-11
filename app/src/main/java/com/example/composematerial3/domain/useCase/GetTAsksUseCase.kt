package com.example.composematerial3.domain.useCase



import com.example.composematerial3.domain.repository.TaskRepository


class GetTasksUseCase(private val taskRepository: TaskRepository){
    operator fun invoke() = taskRepository.getTask()
}