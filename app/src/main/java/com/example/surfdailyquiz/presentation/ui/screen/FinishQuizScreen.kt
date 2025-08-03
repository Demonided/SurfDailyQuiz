package com.example.surfdailyquiz.presentation.ui.screen

import android.R
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.surfdailyquiz.domain.models.QuizResult
import com.example.surfdailyquiz.presentation.ui.component.QuizQuestionResultBlock
import com.example.surfdailyquiz.presentation.ui.component.ResultStep
import com.example.surfdailyquiz.presentation.ui.component.button.ButtonClick
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme
import com.example.surfdailyquiz.presentation.viewmodel.FinishQuizViewModel

@Composable
fun FinishQuizScreenContainer(
    viewModel: FinishQuizViewModel = hiltViewModel() ,
    onClick: () -> Unit ,
    modifier: Modifier = Modifier ,
) {
    val quizResult by viewModel.quizResult
    val quizDataTime by viewModel.quizDataTime

    LaunchedEffect(Unit) {
        viewModel.loadLastQuizResult()
    }

    FinishQuizScreenContent(listQuestions = quizResult , onClick = onClick)
}

@Composable
private fun FinishQuizScreenContent(
    listQuestions: List<QuizResult> ,
    onClick: () -> Unit ,
    modifier: Modifier = Modifier
) {
    Log.d("MyLog" , "Список ответов из БД:\n" + listQuestions.joinToString("\n") {
        "Вопрос: ${it.question}, Выбран: ${it.selectedAnswer}, Правильный: ${it.correctAnswer}, Корректно: ${it.isCorrect}"
    })

    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Результаты" ,
            style = SurfDailyQuizTheme.typography.interBlack.copy(
                fontSize = 32.sp ,
                color = SurfDailyQuizTheme.colors.white
            ) ,
            modifier = Modifier.padding(top = 32.dp , bottom = 14.dp)
        )

        ResultStep(
            questions = listQuestions ,
            modifier = Modifier ,
        )

        if (listQuestions.isNotEmpty()) {
            listQuestions.forEachIndexed { index , question ->
                QuizQuestionResultBlock(
                    questions = question ,
                    currentIndex = index ,
                    size = listQuestions.size ,
                    modifier = Modifier
                )
            }

            ButtonClick(
                text = "Начать заново" ,
                containerColor = SurfDailyQuizTheme.colors.white,
                contentColor = SurfDailyQuizTheme.colors.blue,
                onClick = onClick,
                modifier = Modifier.padding(bottom = 60.dp, top = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FinishQuizScreenPreview() {
    SurfDailyQuizTheme {
        val listQuizResult = listOf(
            QuizResult(
                question = "The buried remains of which English explorer " +
                        "of Australia were found in London  in January 2019? " ,
                selectedAnswer = "Matthew Flinders" ,
                correctAnswer = "Matthew Flinders" ,
                incorrectAnswer = listOf(
                    "William Bourke" ,
                    "Abel Tasman" ,
                    "Dirk Hartog"
                ) ,
                isCorrect = true ,
            ) ,
            QuizResult(
                question = "What airline was the owner of the plane that crashed " +
                        "off the coast of Nova Scotia in 1998?" ,
                selectedAnswer = "British Airways" ,
                correctAnswer = "Swiss Air" ,
                incorrectAnswer = listOf(
                    "Air France" ,
                    "British Airways" ,
                    "TWA"
                ) ,
                isCorrect = false ,
            ) ,
            QuizResult(
                question = "How many furlongs are there in a mile?" ,
                selectedAnswer = "Eight" ,
                correctAnswer = "Eight" ,
                incorrectAnswer = listOf(
                    "Two" ,
                    "Four" ,
                    "Six"
                ) ,
                isCorrect = true ,
            ) ,
            QuizResult(
                question = "What is on display in the Madame Tussaud&#039;s museum in London?" ,
                selectedAnswer = "Wax sculptures" ,
                correctAnswer = "Wax sculptures" ,
                incorrectAnswer = listOf(
                    "Designer clothing" ,
                    "Unreleased film reels" ,
                    "Vintage cars"
                ) ,
                isCorrect = true ,
            ) ,
            QuizResult(
                question = "Which is the second largest native language spoken in Spain by numbers of speakers?" ,
                selectedAnswer = "Catalan" ,
                correctAnswer = "Catalan" ,
                incorrectAnswer = listOf(
                    "Portuguese" ,
                    "Spanish" ,
                    "French"
                ) ,
                isCorrect = true ,
            )
        )

        Surface(color = SurfDailyQuizTheme.colors.blueLight) {
            FinishQuizScreenContent(
                listQuestions = listQuizResult ,
                onClick = {})
        }
    }
}