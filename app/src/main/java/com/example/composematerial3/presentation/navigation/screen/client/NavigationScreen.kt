package com.example.composematerial3.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationScreen(
    val route: String, val title: String,
    val icon: ImageVector
) {
    object Profile :
        NavigationScreen(route = "profile", title = "Profile", icon = Icons.Filled.Person)

    object Home :
        NavigationScreen(route = "home", title = "Home", icon = Icons.Filled.Person)

    object List :
        NavigationScreen(route = "list", title = "Task", icon = Icons.Filled.List)

}
