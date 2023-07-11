package com.example.composematerial3.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composematerial3.data.dataSource.local.dao.TaskDao
import com.example.composematerial3.data.dataSource.local.entity.TaskEntity


@Database(entities =[TaskEntity::class] , version = 1)
abstract class TodoDatabase:RoomDatabase() {

    abstract fun taskDao(): TaskDao

}