package com.example.composematerial3.domain.useCase



import com.example.composematerial3.domain.Resource
import com.example.composematerial3.domain.repository.TaskRepository


class DeleteTaskUseCase (private val taskRepository: TaskRepository) {
    suspend operator fun invoke(id: String): Resource<Unit> {
        return taskRepository.delete(id)
    }

}