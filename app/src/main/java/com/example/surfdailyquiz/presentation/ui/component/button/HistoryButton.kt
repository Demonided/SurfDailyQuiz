package com.example.surfdailyquiz.presentation.ui.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme
import com.example.surfdailyquiz.R

@Composable
fun HistoryButton(
    text: String = "История" ,
    onClick: () -> Unit = {},
    height: Int = 40 ,
    weight: Int = 100 ,
    modifier: Modifier = Modifier
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = SurfDailyQuizTheme.colors.white,
            contentColor = SurfDailyQuizTheme.colors.blueLight
        ),
        modifier = modifier,
        onClick = onClick
    ) {
        Row(
            horizontalArrangement = Arrangement.Center ,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(height.dp)
                .width(weight.dp)
        ) {
            Text(text = text , modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(
                    R.drawable.history_icon ,
                ) ,
                contentDescription = null
            )
        }
    }
}


@Preview
@Composable
fun HistoryButtonPreview() {
    SurfDailyQuizTheme {
        HistoryButton()
    }
}