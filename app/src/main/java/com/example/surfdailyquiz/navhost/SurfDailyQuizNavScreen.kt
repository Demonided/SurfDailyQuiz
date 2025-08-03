package com.example.surfdailyquiz.navhost

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController

@Composable
fun SurfDailyQuizNavScreen(
    startDestination: String,
) {
    val navController = rememberNavController()

    Scaffold(
        containerColor = Color.Transparent,
        snackbarHost = {},
        bottomBar = { }
    ) { paddingValues ->
        SurfDailyQuizNavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(paddingValues)
        )
    }
}