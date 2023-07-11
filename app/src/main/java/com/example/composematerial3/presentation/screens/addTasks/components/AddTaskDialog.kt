package com.example.composematerial3.presentation.screens.addTasks.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.composematerial3.presentation.screens.addTasks.TasksViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTasksDialog(show: Boolean, onDismiss: () -> Unit,  vm: TasksViewModel) {
    val state by vm.taskState.collectAsState()
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
                            Icons.Filled.Check, contentDescription = " ",
                            Modifier
                                .size(29.dp),
                            tint = Color(0xFF07C40E)

                        )

                    }
                    Text(
                        text = "Desea Agreagar una tarea?",
                        Modifier
                            .align(
                                Alignment.CenterHorizontally
                            )
                            .padding(top = 16.dp)
                    )
                    Divider(
                        thickness = 2.dp,
                        color = Color(0xFF07C40E),
                        modifier = Modifier
                            .padding(vertical = 24.dp)
                            .width(560.dp)
                    )
                    OutlinedTextField(
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color(0xFFFCFDFD)
                        ),
                        value = state.task,
                        onValueChange = { vm.onTaskInput(it) },
                        label = { Text("Tarea") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)

                    )
                    Divider(
                        thickness = 2.dp,
                        color = Color(0xFF07C40E),
                        modifier = Modifier
                            .padding(vertical = 24.dp)
                            .width(560.dp)
                    )
                    ButtonsActions(
                        addTask = {
                            vm.onTaskCreated()
                        }, modifier = Modifier.align(
                            Alignment.End
                        ),
                        cancel = { onDismiss() },
                        nameButton = "Aceptar"
                    )
                }

            }

        }
    }

}