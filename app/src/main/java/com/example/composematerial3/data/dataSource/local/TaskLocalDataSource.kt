package com.example.composematerial3.data.dataSource.local

import com.example.composematerial3.data.dataSource.local.entity.TaskEntity
import com.example.composematerial3.domain.model.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskLocalDataSource {
    suspend fun create(task: TaskEntity)
    fun getTask(): Flow<List<TaskEntity>>
    suspend fun update(id: String, task:String)
    suspend fun delete(id: String)
}