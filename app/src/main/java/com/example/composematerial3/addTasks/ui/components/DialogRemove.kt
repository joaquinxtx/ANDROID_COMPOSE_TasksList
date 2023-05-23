package com.example.composematerial3.addTasks.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.composematerial3.addTasks.ui.TasksViewModel
import com.example.composematerial3.addTasks.ui.model.TaskModel


@Composable
fun DialogRemove(show: Boolean, onDismiss: () -> Unit, taskModel: TaskModel ,tasksViewModel: TasksViewModel){

    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Card(
                colors = CardDefaults.cardColors(Color.White)

            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .align(
                                Alignment.CenterHorizontally
                            )
                            .padding(top = 16.dp)
                    ) {
                        Icon(
                            Icons.Filled.Delete, contentDescription = " ",
                            Modifier
                                .size(29.dp),
                            tint = Color.Red

                        )

                    }
                    Text(
                        text = "Esta seguro que quiere eliminar esta tarea?",
                        Modifier
                            .align(
                                Alignment.CenterHorizontally
                            )
                            .padding(top = 16.dp)
                    )
                    Divider(
                        thickness = 1.dp,
                        color = Color.LightGray,
                        modifier = Modifier
                            .padding(vertical = 24.dp)
                            .width(560.dp)
                    )
                    Divider(
                        thickness = 1.dp,
                        color = Color.LightGray,
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .width(560.dp)
                    )
                    ButtonsActions(
                        addTask = {
                            tasksViewModel.onItemRemove(taskModel)

                        }, modifier = Modifier.align(
                            Alignment.End
                        ),
                        cancel = { onDismiss() },
                        nameButton = "Eliminar"
                    )


                }

            }

        }
}
}