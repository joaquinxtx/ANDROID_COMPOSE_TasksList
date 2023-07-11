package com.example.composematerial3.presentation.screens.addTasks

data class TaskCreateState(
    val id:String = "",
    val task:String = "",
    var selected:Boolean = false
)
