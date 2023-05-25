package com.example.composematerial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composematerial3.addTasks.ui.TasksScreen
import com.example.composematerial3.addTasks.ui.TasksViewModel
import com.example.composematerial3.components.scaffold.ScaffoldViewModel
import com.example.composematerial3.ui.theme.ComposeMaterial3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val tasksViewModel : TasksViewModel by viewModels()
    private val scaffoldViewModel : ScaffoldViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoContainerApp( tasksViewModel ,scaffoldViewModel)
        }
    }
}

