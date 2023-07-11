package com.example.composematerial3.di

import com.example.composematerial3.data.dataSource.local.TaskLocalDataSource
import com.example.composematerial3.data.dataSource.local.TaskLocalDataSourceImpl
import com.example.composematerial3.data.dataSource.local.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun providesTaskLocalDataSource(taskDao: TaskDao): TaskLocalDataSource =
        TaskLocalDataSourceImpl(taskDao)

}