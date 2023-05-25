package com.example.composematerial3.addTasks.domain

import com.example.composematerial3.addTasks.data.TaskRepository
import com.example.composematerial3.addTasks.ui.model.TaskModel
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskModel: TaskModel){
        taskRepository.add(taskModel)
    }

}