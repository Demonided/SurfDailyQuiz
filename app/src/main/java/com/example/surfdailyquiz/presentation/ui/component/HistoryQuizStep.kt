package com.example.surfdailyquiz.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme

@Composable
fun HistoryQuizStep(
    correctAnswers: Int ,
    date: String ,
    time: String ,
    size: Int ,
    index: Int ,
    onClick: () -> Unit ,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(40.dp) ,
        modifier = modifier.clickable(
            onClick = onClick
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(104.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 24.dp , bottom = 12.dp)
            ) {
                Text(
                    text = "Quiz ${index + 1}" ,
                    style = SurfDailyQuizTheme.typography.interBold.copy(
                        fontSize = 24.sp ,
                        lineHeight = 24.sp ,
                        color = SurfDailyQuizTheme.colors.blue
                    ) ,
                    modifier = Modifier.align(Alignment.CenterStart)

                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp) ,
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    repeat(size) { index ->
                        val painter =
                            if (index < correctAnswers) R.drawable.star_active else R.drawable.star_inactive

                        Image(
                            painter = painterResource(painter) ,
                            contentDescription = null ,
                            modifier = Modifier.size(16.dp)
                        )
                    }

                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = date ,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Text(
                    text = time ,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    }
}

@Preview
@Composable
fun HistoryQuizStepPreview() {
    SurfDailyQuizTheme {
        Surface(color = SurfDailyQuizTheme.colors.blueLight) {
            HistoryQuizStep(
                correctAnswers = 3 ,
                date = "03.08.2025" ,
                time = "18:20" ,
                size = 5 ,
                index = 1 ,
                modifier = Modifier.padding(16.dp) ,
                onClick = {}
            )
        }
    }
}