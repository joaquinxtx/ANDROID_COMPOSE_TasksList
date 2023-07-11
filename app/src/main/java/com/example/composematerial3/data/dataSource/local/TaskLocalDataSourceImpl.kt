package com.example.composematerial3.data.dataSource.local

import com.example.composematerial3.data.dataSource.local.dao.TaskDao
import com.example.composematerial3.data.dataSource.local.entity.TaskEntity
import com.example.composematerial3.domain.model.TaskModel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskLocalDataSourceImpl(private val taskDao: TaskDao):TaskLocalDataSource {
    override suspend fun create(task: TaskEntity) = taskDao.create(task)

    override fun getTask(): Flow<List<TaskEntity>> = taskDao.getTasks()


    override suspend fun update(id: String, task: String) =taskDao.update(id,task)

    override suspend fun delete(id: String) = taskDao.delete(id)
}