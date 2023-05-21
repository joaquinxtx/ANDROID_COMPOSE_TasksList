package com.example.composematerial3.addTasks.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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