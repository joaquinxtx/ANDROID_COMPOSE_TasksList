package com.example.composematerial3.data.repository
import com.example.composematerial3.data.dataSource.local.TaskLocalDataSource
import com.example.composematerial3.data.mapper.toTaskEntity
import com.example.composematerial3.domain.Resource
import com.example.composematerial3.domain.model.TaskModel
import com.example.composematerial3.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map



class TaskRepositoryImpl (private val localDataSource: TaskLocalDataSource):
    TaskRepository {
    override suspend fun create(task: TaskModel): Resource<TaskModel> {
        localDataSource.create(task.toTaskEntity())
        return Resource.Success(task)
    }


    override fun getTask(): Flow<List<TaskModel>> {
        return localDataSource.getTask().map { taskEntities ->
            taskEntities.map { taskEntity ->
                TaskModel(
                    id = taskEntity.id.toInt(),
                    task = taskEntity.task,
                    selected = taskEntity.selected
                )
            }
        }
    }

    override suspend fun update(id: String, task:TaskModel): Resource<TaskModel> {
        val taskEntity = task.toTaskEntity()
        localDataSource.update(id,taskEntity.task)
        return Resource.Success(task)
    }

    override suspend fun delete(id: String): Resource<Unit> {
        localDataSource.delete(id)
        return Resource.Success(Unit)
    }


}