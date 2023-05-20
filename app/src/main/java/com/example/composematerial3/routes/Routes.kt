package com.example.composematerial3.routes

sealed class Routes(val route : String){
    object TasksList:Routes("taskList")
    object Home:Routes("home")
    object Profile:Routes("profile")


    }