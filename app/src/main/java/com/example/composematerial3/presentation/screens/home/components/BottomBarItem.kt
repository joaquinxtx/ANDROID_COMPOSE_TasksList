package com.example.composematerial3.presentation.screens.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.composematerial3.presentation.navigation.screen.client.NavigationScreen

@Composable
fun RowScope.BottomBarItem(
    screen: NavigationScreen,
    currentDestination: NavDestination,
    navController: NavHostController
) {
    NavigationBarItem(selected = currentDestination.hierarchy.any {
        it.route == screen.route
    }, onClick = {
        navController.navigate(route = screen.route) {
            popUpTo(navController.graph.findStartDestination().id)
        }
    }, label = {
        Text(text = screen.title)
    }, icon = {
        Icon(imageVector = screen.icon, contentDescription = "")
    },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.Cyan,
            selectedIconColor = Color.Red,
            selectedTextColor = Color.Red
        )
    )
}