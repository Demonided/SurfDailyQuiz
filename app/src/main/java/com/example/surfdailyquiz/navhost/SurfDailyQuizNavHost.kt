package com.example.surfdailyquiz.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.surfdailyquiz.presentation.ui.screen.FinishQuizScreenContainer
import com.example.surfdailyquiz.presentation.ui.screen.HistoryScreenComponent
import com.example.surfdailyquiz.presentation.ui.screen.HomeScreenContainer
import com.example.surfdailyquiz.presentation.ui.screen.QuizScreenContainer

@Composable
fun SurfDailyQuizNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            HomeScreenContainer(
                onClickStartQuiz = {
                    navController.navigate(Quiz.route)
                },
                onClickHistory = {
                    navController.navigate(History.route)
                }
            )
        }
        composable(route = Quiz.route) {
            QuizScreenContainer(
                onClick = {
                    navController.navigate(Finish.route)
                },
                onClickBack = {
                    navController.navigate(Home.route) {
                        popUpTo(Quiz.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(route = Finish.route) {
            FinishQuizScreenContainer(
                onClick = {
                    navController.navigate(Quiz.route)
                }
            )
        }
        composable(route = History.route) {
            HistoryScreenComponent(
                onClick = {
                    navController.navigate(Quiz.route)
                }
            )
        }
    }
}