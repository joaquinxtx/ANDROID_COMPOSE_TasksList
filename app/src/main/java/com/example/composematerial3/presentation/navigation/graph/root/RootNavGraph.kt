package com.example.composematerial3.presentation.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composematerial3.presentation.navigation.Graph
import com.example.composematerial3.presentation.screens.home.HomeScreen


@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.CLIENT
    ) {
        composable(route = Graph.CLIENT) {
            HomeScreen()
        }
    }
}