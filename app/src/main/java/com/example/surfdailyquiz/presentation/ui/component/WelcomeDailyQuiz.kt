package com.example.surfdailyquiz.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surfdailyquiz.presentation.ui.component.button.ButtonClick
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme

@Composable
fun WelcomeDailyQuiz(
    onClickStartQuiz: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(40.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center ,
            modifier = Modifier
                .height(206.dp)
                .width(320.dp)
        ) {
            Text(
                text = "Добро подаловать\n в Daily Quiz!" ,
                style = SurfDailyQuizTheme.typography.interBold ,
                textAlign = TextAlign.Center ,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.padding(20.dp))
            ButtonClick(
                text = "Начать викторину" ,
                onClick = onClickStartQuiz
            )
        }
    }
}

@Preview
@Composable
fun WelcomeDailyQuizPreview() {
    SurfDailyQuizTheme {
        WelcomeDailyQuiz(
            onClickStartQuiz = {}
        )
    }
}