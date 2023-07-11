package com.example.composematerial3.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "TaskEntity")
data class TaskEntity(
    @PrimaryKey var id:String = "",
    @ColumnInfo(name = "task") var task:String = "",
    @ColumnInfo(name="selected") var selected:Boolean = false,

)