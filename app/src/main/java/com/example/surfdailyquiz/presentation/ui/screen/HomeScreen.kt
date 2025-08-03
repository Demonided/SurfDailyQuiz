package com.example.surfdailyquiz.presentation.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.surfdailyquiz.R
import com.example.surfdailyquiz.domain.models.Question
import com.example.surfdailyquiz.presentation.state.QuizUiState
import com.example.surfdailyquiz.presentation.ui.component.WelcomeDailyQuiz
import com.example.surfdailyquiz.presentation.ui.component.button.HistoryButton
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme
import com.example.surfdailyquiz.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreenContainer(
    viewModel: HomeViewModel = hiltViewModel(),
    onClickStartQuiz: (List<Question>) -> Unit,
    onClickHistory: () -> Unit
) {
    val quizState by viewModel.quizQuestionState.collectAsState()

    LaunchedEffect(quizState) {
        if (quizState is QuizUiState.Success) {
            onClickStartQuiz((quizState as QuizUiState.Success).questions)
        }
    }

    HomeScreenContent(
        uiState = quizState,
        onClickHistory = onClickHistory,
        onClickStartQuiz = { viewModel.fetchQuizQuestion() }
    )
}

@Composable
private fun HomeScreenContent(
    uiState: QuizUiState = QuizUiState.Idle ,
    onClickStartQuiz: () -> Unit ,
    onClickHistory: () -> Unit ,
) {
    when(uiState) {
        is QuizUiState.Error -> {
            Log.e("HomeScreenContent", "Error: ${uiState.message}")
        }
        is QuizUiState.Loading -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize() ,
            ) {

                Image(
                    painter = painterResource(R.drawable.vector) ,
                    contentDescription = null ,
                    modifier = Modifier.padding(top = 226.dp)
                )
                Spacer(modifier = Modifier.height(116.dp))

                CircularProgressIndicator(
                    trackColor = SurfDailyQuizTheme.colors.white,
                    color = SurfDailyQuizTheme.colors.gray,
                    strokeWidth = 4.dp
                )
            }
        }
        is QuizUiState.Success -> {
            Log.d("HomeScreenContent", "Success")
        }
        QuizUiState.Idle -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize() ,
            ) {
                HistoryButton(
                    modifier = Modifier.padding(top = 100.dp),
                    onClick = onClickHistory
                )
                Spacer(modifier = Modifier.height(116.dp))
                Image(
                    painter = painterResource(R.drawable.vector) ,
                    contentDescription = null ,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(116.dp))
                WelcomeDailyQuiz(
                    onClickStartQuiz = onClickStartQuiz
                )
            }

            Log.d("HomeScreenContent", "Idle")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SurfDailyQuizTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(SurfDailyQuizTheme.colors.blueLight)
        ) {
            HomeScreenContent (
                uiState = QuizUiState.Loading,
                onClickStartQuiz = {},
                onClickHistory = {}
            )
        }
    }
}