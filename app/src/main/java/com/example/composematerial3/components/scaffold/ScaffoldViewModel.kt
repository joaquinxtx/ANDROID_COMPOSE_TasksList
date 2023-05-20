package com.example.composematerial3.components.scaffold

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.composematerial3.routes.Routes

class ScaffoldViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val index: LiveData<Int> = _index

    fun onNavigationWindows(index: Int, navigationController: NavHostController) {
        _index.value = index

        when (index) {
            0 -> {
                navigationController.navigate(Routes.TasksList.route)

            }
            1 -> {
                navigationController.navigate(Routes.Home.route)
            }
            2 -> {
                navigationController.navigate(Routes.Profile.route)
            }
            else -> {
                println("ERRORROO")
            }
        }


    }
}