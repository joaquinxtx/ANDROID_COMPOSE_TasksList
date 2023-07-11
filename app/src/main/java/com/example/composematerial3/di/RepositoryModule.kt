package com.example.composematerial3.di

import com.example.composematerial3.data.dataSource.local.TaskLocalDataSource
import com.example.composematerial3.data.repository.TaskRepositoryImpl
import com.example.composematerial3.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideTaskRepository(
        taskLocalDataSource: TaskLocalDataSource
    ): TaskRepository = TaskRepositoryImpl(taskLocalDataSource)

}