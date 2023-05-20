package com.example.composematerial3.components.scaffold

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(
    content: @Composable () -> Unit,
    scaffoldViewModel: ScaffoldViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Scaffold(
        bottomBar = { MyBottomBar(scaffoldViewModel, navController) },

        ) {
        content()
    }
}


@Composable
fun MyBottomBar(scaffoldViewModel: ScaffoldViewModel, navController: NavHostController) {
    val index: Int by scaffoldViewModel.index.observeAsState(0)

    NavigationBar() {

            NavigationBarItem(
                selected = index == 0,
                onClick = { scaffoldViewModel.onNavigationWindows(index = 0, navController) },
                icon = {
                    Icon(
                        Icons.Filled.List,
                        contentDescription = ""
                    )
                })



            NavigationBarItem(
                selected = index == 1,
                onClick = { scaffoldViewModel.onNavigationWindows(index = 1, navController) },
                icon = {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = ""
                    )
                })


            NavigationBarItem(
                selected = index == 2,
                onClick = { scaffoldViewModel.onNavigationWindows(index = 2, navController) },
                icon = {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = ""
                    )
                })

        }

    }


