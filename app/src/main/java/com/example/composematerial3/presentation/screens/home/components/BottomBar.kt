package com.example.composematerial3.presentation.screens.home.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composematerial3.presentation.navigation.screen.client.NavigationScreen


@Composable
fun BottomBar(navController: NavHostController) {

    val screen = listOf(
        NavigationScreen.Profile,
        NavigationScreen.List,
        NavigationScreen.Home,

    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screen.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomAppBar(
            contentColor = contentColorFor(backgroundColor = Color.LightGray),

            ) {
            screen.forEach {
                if (currentDestination != null) {
                    BottomBarItem(
                        screen = it,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
        }
    }

}