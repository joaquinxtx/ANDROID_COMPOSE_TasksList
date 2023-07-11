package com.example.composematerial3.di

import com.example.composematerial3.domain.repository.TaskRepository
import com.example.composematerial3.domain.useCase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providesCrudUseCase(taskRepository: TaskRepository)=CrudUseCase(
        addTask = AddTaskUseCase(taskRepository),
        getTasks = GetTasksUseCase(taskRepository),
        deleteTask = DeleteTaskUseCase(taskRepository),
        updateTask = UpdateTaskUseCase(taskRepository)
    )
}