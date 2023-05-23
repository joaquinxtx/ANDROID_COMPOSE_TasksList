package com.example.composematerial3

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


import androidx.navigation.compose.rememberNavController
import com.example.composematerial3.addTasks.ui.TasksScreen
import com.example.composematerial3.addTasks.ui.TasksViewModel
import com.example.composematerial3.addTasks.ui.model.TaskModel
import com.example.composematerial3.components.scaffold.MyScaffold
import com.example.composematerial3.components.scaffold.ScaffoldViewModel
import com.example.composematerial3.home.ui.HomeScreen
import com.example.composematerial3.profile.ui.ProfileScreen
import com.example.composematerial3.routes.Routes
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun TodoNavGraph(
    navController: NavHostController = rememberNavController(),
    tasksViewModel: TasksViewModel,
    scaffoldViewModel:ScaffoldViewModel,

) {
    val index: Int by scaffoldViewModel.index.observeAsState(0)
    MyScaffold(content = {  NavHost(navController = navController, startDestination = Routes.TasksList.route) {

        composable(Routes.TasksList.route) {


            TasksScreen(tasksViewModel = tasksViewModel , index = index == 0 )
        }
        composable(Routes.Home.route) {

            HomeScreen(index = index == 1)


        }
        composable(Routes.Profile.route) {
            ProfileScreen(index == 2)
        }
    } }, navController = navController)

}