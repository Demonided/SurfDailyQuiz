package com.example.surfdailyquiz.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.surfdailyquiz.R
import com.example.surfdailyquiz.domain.models.Question
import com.example.surfdailyquiz.presentation.ui.component.QuizStep
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme
import com.example.surfdailyquiz.presentation.viewmodel.QuizViewModel

@Composable
fun QuizScreenContainer(
    viewModel: QuizViewModel = hiltViewModel() ,
    onClickBack: () -> Unit,
    onClick: () -> Unit ,
) {
    val questions = viewModel.questions

    QuizScreenContent(
        questions = questions ,
        onClick = onClick ,
        onClickBack = onClickBack ,
        onAnswerSelected = { questions, answer ->
            viewModel.saveAnswer(questions, answer)
        },
        onResultSelected = { category, difficulty ->
            viewModel.saveQuizResult(category, difficulty)
        },
        modifier = Modifier
    )
}

@Composable
fun QuizScreenContent(
    questions: List<Question> ,
    onClick: () -> Unit ,
    onClickBack: () -> Unit,
    onAnswerSelected: (Question , String) -> Unit ,
    onResultSelected: (String, String) -> Unit ,
    modifier: Modifier = Modifier
) {


    Column(
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = modifier.fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_back_icon) ,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable(
                        onClick = onClickBack
                    )
            )

            Image(
                painter = painterResource(R.drawable.vector) ,
                contentDescription = null ,
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(40.dp)
            )
        }
        QuizStep(
            questions = questions ,
            count = 0 ,
            onClick = onClick ,
            onAnswerSelected = onAnswerSelected,
            onResultSelected = onResultSelected,
            modifier = modifier
        )
        Text(text = "Вернуться к предыдущим вопросам нельзя",
            style = SurfDailyQuizTheme.typography.interRegular,
            modifier = Modifier.padding(top = 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    SurfDailyQuizTheme {
        Surface(color = SurfDailyQuizTheme.colors.blueLight) {
            val listQuestion = listOf(
                Question(
                    type = "multiple" ,
                    difficulty = "difficulty" ,
                    category = "General Knowledge" ,
                    question = "The buried remains of which English explorer " +
                            "of Australia were found in London  in January 2019? " ,
                    correctAnswer = "Matthew Flinders" ,
                    incorrectAnswers = listOf(
                        "William Bourke" ,
                        "Abel Tasman" ,
                        "Dirk Hartog"
                    )
                ) ,
                Question(
                    type = "multiple" ,
                    difficulty = "easy" ,
                    category = "General Knowledge" ,
                    question = "What airline was the owner of the plane that crashed " +
                            "off the coast of Nova Scotia in 1998?" ,
                    correctAnswer = "Swiss Air" ,
                    incorrectAnswers = listOf(
                        "Air France" ,
                        "British Airways" ,
                        "TWA"
                    )
                ) ,
                Question(
                    type = "multiple" ,
                    difficulty = "easy" ,
                    category = "General Knowledge" ,
                    question = "How many furlongs are there in a mile?" ,
                    correctAnswer = "Eight" ,
                    incorrectAnswers = listOf(
                        "Two" ,
                        "Four" ,
                        "Six"
                    )
                ) ,
                Question(
                    type = "multiple" ,
                    difficulty = "easy" ,
                    category = "General Knowledge" ,
                    question = "What is on display in the Madame Tussaud&#039;s museum in London?" ,
                    correctAnswer = "Wax sculptures" ,
                    incorrectAnswers = listOf(
                        "Designer clothing" ,
                        "Unreleased film reels" ,
                        "Vintage cars"
                    )
                ) ,
                Question(
                    type = "multiple" ,
                    difficulty = "easy" ,
                    category = "General Knowledge" ,
                    question = "Which is the second largest native language spoken in Spain by numbers of speakers?" ,
                    correctAnswer = "Catalan" ,
                    incorrectAnswers = listOf(
                        "Portuguese" ,
                        "Spanish" ,
                        "French"
                    )
                )
            )

            QuizScreenContent(
                questions = listQuestion,
                onClick = {},
                onClickBack = {},
                onResultSelected = { _, _ -> },
                onAnswerSelected = { _, _ -> }
            )
        }
    }
}