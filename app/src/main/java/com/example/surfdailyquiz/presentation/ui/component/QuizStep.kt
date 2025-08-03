package com.example.surfdailyquiz.presentation.ui.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.surfdailyquiz.domain.models.Question
import com.example.surfdailyquiz.presentation.ui.component.button.ButtonClick
import com.example.surfdailyquiz.presentation.ui.screen.SelectableCard
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme

@Composable
fun QuizStep(
    questions: List<Question> ,
    count: Int = 0 ,
    onClick: () -> Unit ,
    onAnswerSelected: (Question, String) -> Unit ,
    onResultSelected: (String , String) -> Unit ,
    modifier: Modifier = Modifier
) {
    var currentIndex by remember { mutableStateOf(count) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }

    val shuffledAnswer = remember(currentIndex) {
        val currentQuestion = questions[currentIndex]
        (currentQuestion.incorrectAnswers + currentQuestion.correctAnswer).shuffled()
    }

    val currentQuestion = questions[currentIndex]

    Surface(
        shape = RoundedCornerShape(40.dp) ,
        color = SurfDailyQuizTheme.colors.white

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = modifier
                .height(550.dp)
                .fillMaxWidth()
                .padding(horizontal = 24.dp , vertical = 32.dp)
        ) {
            Text(
                text = "Вопрос ${currentIndex + 1} из ${questions.size}" ,
                style = SurfDailyQuizTheme.typography.interBold.copy(
                    fontSize = 16.sp ,
                    color = SurfDailyQuizTheme.colors.blueDoubleLight
                ) ,
                modifier = Modifier
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally ,
                verticalArrangement = Arrangement.Center ,
                modifier = Modifier.height(92.dp)
            ) {
                Text(
                    text = currentQuestion.question ,
                    style = SurfDailyQuizTheme.typography.interSemiBold ,
                    modifier = Modifier
                )
            }

            shuffledAnswer.forEach { answer ->
                SelectableCard(
                    text = answer,
                    isSelected = selectedAnswer == answer,
                    onClick = {
                        selectedAnswer = answer
                        onAnswerSelected(currentQuestion, answer)
                    })
                Spacer(Modifier.height(16.dp))
            }
            Spacer(modifier = Modifier.height(46.dp))
            ButtonClick(
                text = if (currentIndex != questions.size - 1) "Далее" else "Завершить" ,
                onClick = {
                    onResultSelected(currentQuestion.category, currentQuestion.difficulty)
                    if (currentIndex != questions.size - 1) {
                        currentIndex++
                        selectedAnswer = null
                    } else {
                        onClick()
                    }
                },
                enabled = selectedAnswer != null ,
            )

            Log.d("MyLog", "currentIndex: $currentIndex")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuizStepPreview() {
    SurfDailyQuizTheme {
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

        QuizStep(
            questions = listQuestion ,
            onClick = {},
            onAnswerSelected = { _, _ ->} ,
            onResultSelected = { _, _ ->},
            modifier = Modifier.padding(8.dp)
        )
    }
}