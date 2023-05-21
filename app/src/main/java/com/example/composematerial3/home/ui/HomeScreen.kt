package com.example.composematerial3.home.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun HomeScreen(index: Boolean) {
    AnimatedVisibility(
        visible = index,
        enter = expandHorizontally { 20 },
        exit = shrinkHorizontally(
            // Overwrites the default animation with tween for this shrink animation.
            animationSpec = tween(),
            // Shrink towards the end (i.e. right edge for LTR, left edge for RTL). The default
            // direction for the shrink is towards [Alignment.Start]
            shrinkTowards = Alignment.End,
        ) { fullWidth ->
            // Set the end width for the shrink animation to a quarter of the full width.
            fullWidth / 4
        }
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Blue)) {

        }

    }
}