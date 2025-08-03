package com.example.surfdailyquiz.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.surfdailyquiz.R
import com.example.surfdailyquiz.domain.models.QuizResult
import com.example.surfdailyquiz.presentation.ui.screen.AnswerCard
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme

@Composable
fun QuizQuestionResultBlock(
    questions: QuizResult ,
    currentIndex: Int = 0,
    size: Int = 5,
    modifier: Modifier = Modifier
) {
    val allAnswer = remember(currentIndex) {
        (questions.incorrectAnswer + questions.correctAnswer).shuffled()
    }

    Surface(
        shape = RoundedCornerShape(40.dp) ,
        modifier = modifier.padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 24.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp , bottom = 16.dp)
            ) {
                Text(
                    text = "Вопрос ${currentIndex + 1} из $size" ,
                    style = SurfDailyQuizTheme.typography.interSemiBold.copy(
                        fontSize = 16.sp ,
                        color = SurfDailyQuizTheme.colors.gray
                    ),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Image(
                    painter = painterResource(id = R.drawable.property_right) ,
                    contentDescription = "Question Icon",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Text(text = questions.question,
                modifier = Modifier.padding(bottom = 24.dp),
                style = SurfDailyQuizTheme.typography.interSemiBold)

            allAnswer.forEach { answer ->
                AnswerCard(
                    answer = answer ,
                    correctAnswer = questions.correctAnswer ,
                    selectedAnswer = questions.selectedAnswer ,
                    modifier = Modifier
                )
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizQuestionResultBlockPreview() {
    SurfDailyQuizTheme {
        val quizResult =
            QuizResult(
                question = "How many furlongs are there in a mile?" ,
                selectedAnswer = "Two" ,
                correctAnswer = "Eight" ,
                incorrectAnswer = listOf(
                    "Two" ,
                    "Four" ,
                    "Six"
                ),
                isCorrect = false ,
            )

        Surface(
            color = SurfDailyQuizTheme.colors.blueLight ,
        ) {
            QuizQuestionResultBlock(
                questions = quizResult
            )
        }
    }
}