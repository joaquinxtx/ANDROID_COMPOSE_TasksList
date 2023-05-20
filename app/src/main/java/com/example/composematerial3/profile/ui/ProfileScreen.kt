package com.example.composematerial3.profile.ui

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ProfileScreen(index:Boolean){
    AnimatedVisibility(
        visible = index ,
        enter = scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically),
        exit = scaleOut() + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
    ){

Box(Modifier.fillMaxSize().background(Color.Gray)){

}
    }
}