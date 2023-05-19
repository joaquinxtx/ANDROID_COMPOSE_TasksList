package com.example.composematerial3.addTasks.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape

import androidx.compose.foundation.shape.RoundedCornerShape


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.*
import androidx.compose.material3.ShapeDefaults.ExtraLarge
import androidx.compose.material3.ShapeDefaults.Medium
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun TasksScreen(tasksViewModel: TasksViewModel) {
    Box() {
        FabDialog(Modifier.align(Alignment.BottomEnd))

    }
}

@Composable
fun FabDialog(modifier: Modifier) {
    AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {})
    FloatingActionButton(onClick = {
        //dialog
    }, modifier = modifier) {
        Icon(Icons.Filled.Add, contentDescription = "")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTasksDialog(show: Boolean, onDismiss: () -> Unit,onTaskAdded:(String)->Unit) {
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
                        colors =TextFieldDefaults.textFieldColors(Color.Gray),
                        value = myTask,
                        onValueChange = { myTask = it },
                        label = { Text("Tarea") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp).background(Color.White)
                    )
                    Divider(
                        thickness = 1.dp,
                        color = Color.LightGray,
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .width(560.dp)
                    )
                    ButtonsActions(
                        addTask = { onTaskAdded(myTask) }, modifier = Modifier.align(
                            Alignment.End
                        )
                    ) {

                    }


                }

            }

        }
    }

}

@Composable
fun ButtonsActions(modifier: Modifier, addTask: () -> Unit, cancel: () -> Unit) {
    Row(modifier = modifier.padding(bottom = 16.dp)) {
        TextButton(onClick = { cancel() }) {
            Text(text = "Cancel")
        }
        TextButton(onClick = { addTask() }) {
            Text(text = "Accept")
        }

    }

}

