package com.example.composematerial3.domain.useCase


import com.example.composematerial3.domain.Resource
import com.example.composematerial3.domain.model.TaskModel
import com.example.composematerial3.domain.repository.TaskRepository


class AddTaskUseCase (private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskModel: TaskModel): Resource<TaskModel> {
        return taskRepository.create(taskModel)
    }
}