package com.example.composematerial3.addTasks.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTasksDialog(show: Boolean, onDismiss: () -> Unit, onTaskAdded: (String) -> Unit) {
    var myTask by remember { mutableStateOf("") }
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
                                .size(29.dp)

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
                        thickness = 1.dp,
                        color = Color.LightGray,
                        modifier = Modifier
                            .padding(vertical = 24.dp)
                            .width(560.dp)
                    )
                    OutlinedTextField(
                        colors = TextFieldDefaults.textFieldColors(Color.Gray),
                        value = myTask,
                        onValueChange = { myTask = it },
                        label = { Text("Tarea") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .background(Color.White)
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
                            onTaskAdded(myTask)
                            myTask=""

                            }, modifier = Modifier.align(
                            Alignment.End
                        ),
                        cancel = { onDismiss() }
                    )


                }

            }

        }
    }

}