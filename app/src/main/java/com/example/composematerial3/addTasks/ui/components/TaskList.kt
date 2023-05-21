package com.example.composematerial3.addTasks.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composematerial3.addTasks.ui.model.TaskModel


@Composable
fun TasksList(tasksViewModel: TasksViewModel) {
    val myTask: List<TaskModel> = tasksViewModel.task
    LazyColumn {
        items(myTask, key = { it.id }) { task ->
            ItemTask(task, tasksViewModel = tasksViewModel)
        }
    }

}

@Composable
fun ItemTask(taskModel: TaskModel, tasksViewModel: TasksViewModel) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = taskModel.task, modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f), style = TextStyle(fontSize = 20.sp , fontWeight = FontWeight.Bold )
            )
            Checkbox(
                checked = taskModel.selected,
                onCheckedChange = { tasksViewModel.onCheckBoxSelected(taskModel) })
        }
    }
}