package com.example.composematerial3.data.dataSource.local.dao

import androidx.room.*
import com.example.composematerial3.data.dataSource.local.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * from TaskEntity")
    fun getTasks():Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(item: TaskEntity)

    @Query("UPDATE TaskEntity SET task = :task WHERE id = :id")
    suspend fun update(id: String, task: String)

    @Query("DELETE FROM TaskEntity WHERE id = :id")
    suspend fun delete(id: String)

}