package com.example.composematerial3.addTasks.domain

import com.example.composematerial3.addTasks.data.TaskRepository
import com.example.composematerial3.addTasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val taskRepository: TaskRepository){
    operator fun invoke(): Flow<List<TaskModel>> = taskRepository.tasks
}