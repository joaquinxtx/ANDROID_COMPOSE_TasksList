package com.example.composematerial3.presentation.navigation.screen.client



import com.example.composematerial3.R

sealed class NavigationScreen(
    val route: String, val title: String,
    val icon:Int
) {
    object Home :
        NavigationScreen(
            route = "home",
            title = "Home",
            icon = R.drawable.estadisticas
        )

    object List :
        NavigationScreen(route = "list", title = "Task", icon = R.drawable.tarea)


    object Profile :
        NavigationScreen(route = "profile", title = "Profile", icon = R.drawable.hombre)

}
