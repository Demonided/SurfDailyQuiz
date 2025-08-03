package com.example.surfdailyquiz.presentation.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.surfdailyquiz.R
import com.example.surfdailyquiz.data.local.database.QuizWithAnswers
import com.example.surfdailyquiz.data.local.database.entity.QuizResultEntity
import com.example.surfdailyquiz.data.local.database.entity.QuizTaskResultEntity
import com.example.surfdailyquiz.presentation.ui.component.EmptyHistoryQuiz
import com.example.surfdailyquiz.presentation.ui.component.HistoryQuizStep
import com.example.surfdailyquiz.presentation.ui.result.HistoryUiState
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme
import com.example.surfdailyquiz.presentation.viewmodel.HistoryViewModel
import com.example.surfdailyquiz.utils.formatDate
import com.example.surfdailyquiz.utils.formatTime

@Composable
fun HistoryScreenComponent(
    viewModel: HistoryViewModel = hiltViewModel() ,
    onClick: () -> Unit
) {
    val uiState by viewModel.uiHistoryState

    HistoryScreenContent(
        uiState = uiState ,
        onClick = onClick ,
        onLongClick = { quiz -> viewModel.deleteQuiz(quiz) }
    )
}

@Composable
private fun HistoryScreenContent(
    uiState: HistoryUiState ,
    onClick: () -> Unit,
    onLongClick: (QuizWithAnswers) -> Unit ,
    modifier: Modifier = Modifier ,
) {
    var selectionQuiz = remember { mutableStateOf<QuizWithAnswers?>(null) }

    when (uiState) {
        is HistoryUiState.Empty -> {
            Box(modifier = modifier.fillMaxSize()) {
                Text(
                    text = "История" ,
                    style = SurfDailyQuizTheme.typography.interBlack.copy(
                        fontSize = 32.sp ,
                        color = SurfDailyQuizTheme.colors.white
                    ) ,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 86.dp)
                )
                EmptyHistoryQuiz(
                    onClick = onClick ,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 160.dp)
                        .padding(horizontal = 20.dp) ,
                )
                Image(
                    painter = painterResource(R.drawable.vector) ,
                    contentDescription = null ,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 80.dp)
                )
            }
        }

        is HistoryUiState.Success -> {
            val quizList = uiState.history.filter { it.answers.size == 5 }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally ,
                modifier = modifier.fillMaxSize()
            ) {
                Text(
                    text = "История" ,
                    style = SurfDailyQuizTheme.typography.interBlack.copy(
                        fontSize = 32.sp ,
                        color = SurfDailyQuizTheme.colors.white
                    ) ,
                    modifier = Modifier
                        .padding(top = 86.dp , bottom = 40.dp)
                )

                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    itemsIndexed(quizList) { index , quiz ->
                        val isSelected = selectionQuiz.value?.quiz?.id == quiz.quiz.id

                        Log.d("MyLog", "Тут isSelected: $isSelected")
                        HistoryQuizStep(
                            correctAnswers = quiz.quiz.countCorrect ,
                            date = formatDate(quiz.quiz.time) ,
                            time = formatTime(quiz.quiz.time) ,
                            size = quiz.answers.size ,
                            index = index ,
                            modifier = Modifier
                                .graphicsLayer {
                                    alpha = if (selectionQuiz != null || isSelected) 1f else 0.3f
                                }
                                .pointerInput(Unit) {
                                    detectTapGestures(
                                        onLongPress = { selectionQuiz.value = quiz } ,
                                        onTap = {
                                            if (selectionQuiz != null) {
                                                selectionQuiz.value = null
                                            } else {
                                                onClick()
                                            }
                                        }
                                    )
                                } ,
                            onClick = onClick
                        )
                    }
                }
            }

            selectionQuiz.value?.let { quiz ->
                Box(modifier = Modifier.fillMaxSize()) {
                    IconButton(
                        onClick = {
                            onLongClick(quiz)
                            selectionQuiz.value = null
                        } ,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(16.dp)
                            .background(
                                color = Color.Red.copy(alpha = 0.9f) ,
                                shape = CircleShape
                            ) ,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Удалить",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HistoryScreenPreviewEmpty() {
    SurfDailyQuizTheme {
        Column {
            Surface(color = SurfDailyQuizTheme.colors.blueLight) {
                HistoryScreenContent(
                    onClick = {},
                    onLongClick = {},
                    uiState = HistoryUiState.Empty
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HistoryScreenPreviewSuccess() {
    SurfDailyQuizTheme {
        Column {
            Surface(color = SurfDailyQuizTheme.colors.blueLight) {
                HistoryScreenContent(
                    onClick = {},
                    onLongClick = {},
                    uiState = HistoryUiState.Success(
                        generateFakeQuizWithAnswersList()
                    )
                )
            }
        }
    }
}

fun generateFakeQuizWithAnswersList(): List<QuizWithAnswers> {
    return List(5) { index ->
        val quiz = QuizResultEntity(
            id = index ,
            data = "2025-08-0${index + 1}" ,
            time = System.currentTimeMillis() - index * 100000 ,
            countCorrect = (1..5).random() ,
            category = "General Knowledge" ,
            difficulty = "medium"
        )

        val answers = List(5) { answerIndex ->
            QuizTaskResultEntity(
                id = answerIndex + 1 ,
                quizResultId = quiz.id ,
                question = "Question ${answerIndex + 1}" ,
                correctedAnswer = "Correct Answer ${answerIndex + 1}" ,
                selectedAnswer = "Selected Answer ${answerIndex + 1}" ,
                incorrectAnswers = listOf("Wrong 1" , "Wrong 2" , "Wrong 3") ,
                isCorrect = (0..1).random() == 1 ,
            )
        }

        QuizWithAnswers(quiz = quiz , answers = answers)
    }
}
