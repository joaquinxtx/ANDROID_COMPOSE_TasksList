package com.example.composematerial3.domain.model

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class TaskModel(
    val id: Int ,
    val task: String ,
    var selected: Boolean = false
)
