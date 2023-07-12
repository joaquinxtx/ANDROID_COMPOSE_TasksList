package com.example.composematerial3.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable



import com.example.composematerial3.presentation.navigation.Graph
import com.example.composematerial3.presentation.navigation.screen.client.NavigationScreen
import com.example.composematerial3.presentation.screens.HomeOrigin.HomeOriginScreen
import com.example.composematerial3.presentation.screens.addTasks.TasksScreen

import com.example.composematerial3.presentation.screens.profile.ProfileScreen


@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = NavigationScreen.List.route
    ) {
        composable(route = NavigationScreen.List.route) {
            TasksScreen(navController)
        }
        composable(route = NavigationScreen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(route = NavigationScreen.Home.route) {
            HomeOriginScreen(navController)
        }
    }
}


