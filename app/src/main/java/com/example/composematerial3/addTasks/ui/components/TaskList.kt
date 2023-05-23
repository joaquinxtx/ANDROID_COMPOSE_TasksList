package com.example.composematerial3.addTasks.ui

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.splineBasedDecay
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composematerial3.addTasks.ui.components.DialogRemove
import com.example.composematerial3.addTasks.ui.model.TaskModel
import kotlin.math.roundToInt


@Composable
fun TasksList(tasksViewModel: TasksViewModel) {
    val showDialogRemove: Boolean by tasksViewModel.showDialogRemove.observeAsState(false)
    val myTask: List<TaskModel> = tasksViewModel.task
    LazyColumn {
        items(myTask, key = { it.id }) { task ->
            ItemTask(task, tasksViewModel = tasksViewModel)
            DialogRemove(
                show = showDialogRemove,
                onDismiss = { tasksViewModel.onDialogRemoveClose() },
                taskModel =task ,
                tasksViewModel = tasksViewModel
            )
        }
    }

}

@Composable
fun ItemTask(taskModel: TaskModel, tasksViewModel: TasksViewModel) {
    val offsetX = remember { mutableStateOf(0f) }
    val offsetY = remember { mutableStateOf(0f) }
    var width by remember { mutableStateOf(0f) }
    Card(
        Modifier
            .fillMaxWidth()
            .onSizeChanged { width = it.width.toFloat() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .offset { IntOffset(offsetX.value.roundToInt(), offsetY.value.roundToInt()) }
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    val originalX = offsetX.value
                    val newValue = (originalX + dragAmount).coerceIn(0f, width - 300.dp.toPx())
                    offsetX.value = newValue
                     if (offsetX.value == width - 300.dp.toPx()) {
                        tasksViewModel.onShowDialogRemove()
                    }
                }
            },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = taskModel.task, modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Checkbox(
                checked = taskModel.selected,
                onCheckedChange = { tasksViewModel.onCheckBoxSelected(taskModel) })
        }
    }
}