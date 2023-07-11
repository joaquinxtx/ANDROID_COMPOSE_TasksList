package com.example.composematerial3.presentation.screens.addTasks.mapper

import com.example.composematerial3.domain.model.TaskModel
import com.example.composematerial3.presentation.screens.addTasks.TaskCreateState
import java.util.*

fun TaskCreateState.toTask(): TaskModel {
    val idInt = if (id.isNotEmpty()) {
        id.toInt()
    } else {
        // Generar un nuevo id único en caso de que id esté vacío
        UUID.randomUUID().hashCode()
    }
    return TaskModel(
        id = idInt,
        task = task,
        selected = selected
    )
}