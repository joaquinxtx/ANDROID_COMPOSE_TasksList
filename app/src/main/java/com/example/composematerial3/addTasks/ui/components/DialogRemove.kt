package com.example.composematerial3.addTasks.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
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
fun DialogRemove( onDismiss: () -> Unit,  onConfirm:()-> Unit){


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
                            Icons.Outlined.Delete, contentDescription = " ",
                            Modifier
                                .size(29.dp),
                            tint = Color.Red

                        )

                    }
                    Divider(
                        thickness = 2.dp,
                        color = Color( 0xFFFFAB00),
                        modifier = Modifier
                            .padding(vertical = 24.dp)
                            .width(560.dp)
                    )
                    Text(
                        text = "Desea eliminar tarea?",
                        Modifier
                            .align(
                                Alignment.CenterHorizontally
                            )

                    )

                    Divider(
                        thickness = 2.dp,
                        color = Color( 0xFFFFAB00),
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .width(560.dp)
                    )
                    ButtonsActions(
                        addTask = {
                            onConfirm()

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
