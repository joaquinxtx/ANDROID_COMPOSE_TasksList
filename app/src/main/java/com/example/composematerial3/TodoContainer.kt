package com.example.composematerial3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composematerial3.addTasks.ui.TasksScreen
import com.example.composematerial3.addTasks.ui.TasksViewModel
import com.example.composematerial3.addTasks.ui.model.TaskModel
import com.example.composematerial3.components.scaffold.MyScaffold
import com.example.composematerial3.components.scaffold.ScaffoldViewModel
import com.example.composematerial3.ui.theme.ComposeMaterial3Theme

@Composable
fun TodoContainerApp(
    tasksViewModel: TasksViewModel,
    scaffoldViewModel: ScaffoldViewModel


    ) {
    ComposeMaterial3Theme {
            TodoNavGraph(tasksViewModel = tasksViewModel, scaffoldViewModel = scaffoldViewModel)

    }

}
