package com.example.surfdailyquiz.presentation.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.surfdailyquiz.R

data class SurfDailyQuizTypography(
    val interBlack: TextStyle = TextStyle(
        fontFamily =  interFamily ,
        fontWeight = FontWeight.Black ,
        fontSize = 16.sp ,
        lineHeight = 24.sp ,
        textAlign = TextAlign.Center
    ),
    val interBold: TextStyle = TextStyle(
        fontFamily =  interFamily ,
        fontWeight = FontWeight.Bold ,
        fontSize = 28.sp ,
        lineHeight = 28.sp ,
        textAlign = TextAlign.Center
    ),
    val interSemiBold: TextStyle = TextStyle(
        fontFamily =  interFamily ,
        fontWeight = FontWeight.SemiBold ,
        fontSize = 18.sp ,
        lineHeight = 18.sp ,
        textAlign = TextAlign.Center
    ),
    val interRegular: TextStyle = TextStyle(
        fontFamily =  interFamily ,
        fontWeight = FontWeight.Normal ,
        fontSize = 10.sp ,
        lineHeight = 10.sp ,
        textAlign = TextAlign.Center
    ),
)

val interFamily = FontFamily(
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_semi_bold, FontWeight.SemiBold),
    Font(R.font.inter_black, FontWeight.Black),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_regular, FontWeight.Normal),
)