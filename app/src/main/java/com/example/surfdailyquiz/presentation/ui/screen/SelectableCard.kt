package com.example.surfdailyquiz.presentation.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
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
fun SelectableCard(
    text: String ,
    height: Int = 52 ,
    isSelected: Boolean = false ,
    onClick: () -> Unit = {} ,
    modifier: Modifier = Modifier
) {
    val borderColor = if (isSelected) SurfDailyQuizTheme.colors.blueLight else Color.Transparent
    val icon = if (isSelected) R.drawable.property_selected else R.drawable.radio_button

    Surface(
        shape = RoundedCornerShape(16.dp) ,
        border = BorderStroke(1.dp , borderColor) ,
        color = SurfDailyQuizTheme.colors.whiteLight ,
        modifier = modifier
            .clickable(onClick = onClick)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically ,
            modifier = modifier
                .fillMaxWidth()
                .height(height.dp)
        )
        {
            Image(
                painter = painterResource(icon) ,
                contentDescription = null ,
                modifier = Modifier.padding(16.dp)
            )
            Text(text = text)
        }
    }
}

@Preview(showBackground = false)
@Composable
fun SelectableCardPreview() {
    SurfDailyQuizTheme {
        Surface(color = SurfDailyQuizTheme.colors.white) {
            SelectableCard(
                text = "Sample Text" ,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}