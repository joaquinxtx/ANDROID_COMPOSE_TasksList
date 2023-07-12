package com.example.composematerial3.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    NavigationBarItem(
        selected = currentDestination.hierarchy.any {
            it.route == screen.route
        },
        onClick = {
            navController.navigate(route = screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
            }
        },
        label = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 5.dp)
            ) {
                Text(
                    text = screen.title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        },
        icon = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = screen.icon),
                    contentDescription = "",
                    modifier = Modifier.size(22.dp)
                )
            }
        },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.LightGray,
            selectedIconColor = Color.Red,
            selectedTextColor = Color.Gray
        )
    )
}