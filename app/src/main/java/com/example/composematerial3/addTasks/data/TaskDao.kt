package com.example.composematerial3.addTasks.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * from TaskEntity")
    fun getTasks():Flow<List<TaskEntity>>

    @Insert
    suspend fun addTask(item:TaskEntity)

    @Update
    suspend fun updateTask(item: TaskEntity)

    @Delete
    suspend fun remove(item:TaskEntity)

}