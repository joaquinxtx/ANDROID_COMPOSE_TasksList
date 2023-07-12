package com.example.composematerial3.domain.model



data class TaskModel(
    val id: Int ,
    val task: String ,
    var selected: Boolean = false
)
