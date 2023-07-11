package com.example.composematerial3.domain.useCase


import com.example.composematerial3.domain.model.TaskModel
import com.example.composematerial3.domain.repository.TaskRepository


class UpdateTaskUseCase (private val taskRepository: TaskRepository) {
    suspend operator fun invoke(id: String, taskModel: TaskModel) =
        taskRepository.update(id, taskModel)


}