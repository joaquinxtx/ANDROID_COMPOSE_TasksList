package com.example.composematerial3.domain.repository


import com.example.composematerial3.domain.Resource
import com.example.composematerial3.domain.model.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun create(task: TaskModel):Resource<TaskModel>
    fun getTask(): Flow<List<TaskModel>>
    suspend fun update(id: String, task: TaskModel):Resource<TaskModel>
    suspend fun delete(id: String) : Resource<Unit>


}