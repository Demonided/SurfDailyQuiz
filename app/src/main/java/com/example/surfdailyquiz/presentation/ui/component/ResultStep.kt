package com.example.surfdailyquiz.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.surfdailyquiz.R
import com.example.surfdailyquiz.domain.models.QuizResult
import com.example.surfdailyquiz.presentation.ui.component.button.ButtonClick
import com.example.surfdailyquiz.presentation.ui.result.ResultTextProvider
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme

@Composable
fun ResultStep(
    questions: List<QuizResult> ,
    modifier: Modifier = Modifier ,
) {
    val correctCount = questions.count { it.isCorrect }
    val result = ResultTextProvider.getResultText(correctCount)


    Surface(
        shape = RoundedCornerShape(40.dp) ,
        modifier = modifier.padding(horizontal = 20.dp , vertical = 10.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(horizontal = 30.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally ,

                ) {
                Row(
                    modifier = Modifier.padding(vertical = 24.dp) ,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(5) { index ->
                        val starRes =
                            if (index < correctCount) R.drawable.star_active else R.drawable.star_inactive

                        Image(
                            painter = painterResource(id = starRes) ,
                            contentDescription = null ,
                            modifier = Modifier.size(52.dp)
                        )
                    }
                }
                Text(
                    text = "$correctCount из 5" ,
                    style = SurfDailyQuizTheme.typography.interBold.copy(
                        fontSize = 16.sp ,
                        color = SurfDailyQuizTheme.colors.yellow
                    )
                )
                Text(
                    text = result.title ,
                    style = SurfDailyQuizTheme.typography.interBold.copy(
                        fontSize = 24.sp ,
                    ) ,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
                Text(
                    text = result.subtitle ,
                    style = SurfDailyQuizTheme.typography.interRegular.copy(
                        fontSize = 16.sp ,
                        lineHeight = 16.sp
                    )
                )
            }
            ButtonClick(
                onClick = {} ,
                text = "Начать заново" ,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultStepPreview() {
    SurfDailyQuizTheme {
        val listQuizResult = listOf(
            QuizResult(
                question = "The buried remains of which English explorer " +
                        "of Australia were found in London  in January 2019? ",
                selectedAnswer = "Matthew Flinders",
                correctAnswer = "Matthew Flinders",
                incorrectAnswer = listOf(
                    "William Bourke" ,
                    "Abel Tasman" ,
                    "Dirk Hartog"
                ),
                isCorrect = true,
            ) ,
            QuizResult(
                question = "What airline was the owner of the plane that crashed " +
                        "off the coast of Nova Scotia in 1998?",
                selectedAnswer = "British Airways",
                correctAnswer = "Swiss Air" ,
                incorrectAnswer = listOf(
                    "Air France" ,
                    "British Airways" ,
                    "TWA"
                ),
                isCorrect = false,
            ) ,
            QuizResult(
                question = "How many furlongs are there in a mile?",
                selectedAnswer = "Eight" ,
                correctAnswer = "Eight" ,
                incorrectAnswer = listOf(
                    "Two" ,
                    "Four" ,
                    "Six"
                ),
                isCorrect = true,
            ) ,
            QuizResult(
                question = "What is on display in the Madame Tussaud&#039;s museum in London?" ,
                selectedAnswer = "Vintage cars",
                correctAnswer = "Wax sculptures",
                incorrectAnswer = listOf(
                    "Designer clothing" ,
                    "Unreleased film reels" ,
                    "Vintage cars"
                ),
                isCorrect = false,
            ) ,
            QuizResult(
                question = "Which is the second largest native language spoken in Spain by numbers of speakers?",
                selectedAnswer = "Portuguese",
                correctAnswer = "Catalan",
                incorrectAnswer = listOf(
                    "Portuguese" ,
                    "Spanish" ,
                    "French"
                ),
                isCorrect = false,
            )
        )

        Surface(color = SurfDailyQuizTheme.colors.blueLight) {
            ResultStep(questions = listQuizResult)
        }
    }
}