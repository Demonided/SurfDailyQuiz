package com.example.surfdailyquiz.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.surfdailyquiz.presentation.ui.component.button.ButtonClick
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme

@Composable
fun EmptyHistoryQuiz(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(shape = RoundedCornerShape(40.dp),
        modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Вы еще не проходили\n ни одной викторины",
                style = SurfDailyQuizTheme.typography.interRegular.copy(
                    fontSize = 20.sp,
                    lineHeight = 20.sp
                ),
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp))
            ButtonClick(
                text = "Начать викторину" ,
                onClick = onClick,
                modifier = Modifier.padding(bottom = 24.dp, top = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun EmptyHistoryQuizPreview() {
    SurfDailyQuizTheme {
        Surface(color = SurfDailyQuizTheme.colors.blueLight) {
            EmptyHistoryQuiz(onClick = {}, modifier = Modifier.padding(16.dp))
        }
    }
}