package com.example.surfdailyquiz.presentation.ui.component.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme

@Composable
fun ButtonClick(
    text: String ,
    height: Int = 50 ,
    width: Int = 260 ,
    containerColor: Color = SurfDailyQuizTheme.colors.blueLight ,
    contentColor: Color = SurfDailyQuizTheme.colors.white,
    modifier: Modifier = Modifier ,
    enabled: Boolean = true ,
    onClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(16.dp) ,
        onClick = onClick ,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        modifier = modifier
            .height(height.dp)
            .width(width.dp)
    ) {
        Text(
            text = text.uppercase() ,
            style = SurfDailyQuizTheme.typography.interBlack
        )
    }
}

@Preview
@Composable
fun ButtonClickPreview() {
    SurfDailyQuizTheme {
        ButtonClick(text = "Click Me") { }
    }
}