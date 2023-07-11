package com.example.composematerial3.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.*

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composematerial3.presentation.navigation.graph.client.ClientNavGraph
import com.example.composematerial3.presentation.screens.home.components.BottomBar


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

    Scaffold(bottomBar = { BottomBar(navController = navController) }) {
        ClientNavGraph(navController = navController)
    }
}


