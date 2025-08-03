package com.example.surfdailyquiz.presentation.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surfdailyquiz.R
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme

@Composable
fun AnswerCard(
    answer: String ,
    correctAnswer: String ,
    selectedAnswer: String ,
    modifier: Modifier = Modifier
) {
    val isSelected = selectedAnswer == answer
    val isCorrect = answer == correctAnswer

    val borderColor = when {
        isSelected && isCorrect -> SurfDailyQuizTheme.colors.green
        isSelected && !isCorrect -> SurfDailyQuizTheme.colors.red
        else -> Color.Transparent
    }

    val icon = when {
        isSelected && isCorrect -> R.drawable.property_right
        isSelected && !isCorrect -> R.drawable.property_wrong
        else -> R.drawable.radio_button
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, borderColor),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically ,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = answer,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview
@Composable
fun AnswerCardPreview() {
    SurfDailyQuizTheme{
        Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            AnswerCard(
                answer = "Answer 1" ,
                correctAnswer = "Answer 1" ,
                selectedAnswer = "Answer 1"
            )

            AnswerCard(
                answer = "Answer 1" ,
                correctAnswer = "Answer 2" ,
                selectedAnswer = "Answer 1"
            )

            AnswerCard(
                answer = "Answer 3" ,
                correctAnswer = "Answer 2" ,
                selectedAnswer = "Answer 1"
            )
        }
    }
}