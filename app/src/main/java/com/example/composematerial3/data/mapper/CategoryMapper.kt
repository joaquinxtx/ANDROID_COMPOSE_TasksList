package com.example.composematerial3.data.mapper

import com.example.composematerial3.data.dataSource.local.entity.TaskEntity
import com.example.composematerial3.domain.model.TaskModel

fun TaskEntity.toTask():TaskModel{
    return TaskModel(
        id = id.toInt(),
        task = task,
        selected=selected

    )

}

fun TaskModel.toTaskEntity():TaskEntity{
    return TaskEntity(
        id=id.toString(),
        task=task,
        selected=selected
    )
}