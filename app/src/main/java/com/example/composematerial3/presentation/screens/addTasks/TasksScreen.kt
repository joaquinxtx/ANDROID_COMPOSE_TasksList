package com.example.composematerial3.presentation.screens.addTasks

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composematerial3.presentation.screens.addTasks.components.ContentTask

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TasksScreen(navHostController: NavHostController) {
    Scaffold {
          ContentTask()
      }



}







