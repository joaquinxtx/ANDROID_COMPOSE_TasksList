package com.example.composematerial3.presentation.screens.addTasks.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composematerial3.R
import com.example.composematerial3.domain.model.TaskModel
import com.example.composematerial3.presentation.screens.addTasks.TasksViewModel
import kotlin.math.roundToInt


@Composable
fun TasksList(tasks: List<TaskModel>, vm: TasksViewModel = hiltViewModel()) {

    val showDialogRemove: Boolean by vm.showDialogRemove.observeAsState(false)
    if (tasks.isEmpty()) {
        // Mostrar imagen en el centro de la pantalla
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.emtylist),
                contentDescription = "Empty Image"
            )
        }
    }else{

        LazyColumn {
            items(tasks, key = { it.id }) { task ->
                ItemTask(task, vm = vm)
                if (showDialogRemove) {
                    DialogRemove(
                        onDismiss = { vm.onDialogRemoveClose() },
                        onConfirm = {
                            val selectedIndex = vm.selectedItemIndex.value ?: -1
                            if (selectedIndex != -1) {
                                val selectedItem = tasks[selectedIndex]
                                vm.onItemRemove(selectedItem)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ItemTask(taskModel: TaskModel, vm: TasksViewModel ) {

    var isSelected by remember { mutableStateOf(taskModel.selected) }

    val offsetX = remember { mutableStateOf(0f) }
    val offsetY = remember { mutableStateOf(0f) }
    var width by remember { mutableStateOf(0f) }
    Card(
        colors = CardDefaults.cardColors(Color(0xFFF7F6F6)),
        modifier = Modifier
            .fillMaxWidth()
            .onSizeChanged { width = it.width.toFloat() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .offset { IntOffset(offsetX.value.roundToInt(), offsetY.value.roundToInt()) }
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragCancel = { offsetX.value = 0f },
                    onDragEnd = { offsetX.value = 0f },
                    onHorizontalDrag = { change, dragAmount ->
                        val originalX = offsetX.value
                        val newValue = (originalX + dragAmount).coerceIn(0f, width - 300.dp.toPx())
                        offsetX.value = newValue
                        if (offsetX.value == width - 300.dp.toPx()) {
                            vm.onShowDialogRemove(taskModel)
                        }
                    })
            },
        elevation = CardDefaults.cardElevation(6.dp),

        ) {

        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = taskModel.task,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            )
            Checkbox(

                checked =isSelected,
                onCheckedChange = {
                    isSelected = it // Actualiza el estado de selección
                    taskModel.selected = it
                    vm.onCheckBoxSelected(taskModel)
                                  },


            )
        }
    }
}