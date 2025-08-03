package com.example.surfdailyquiz.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

object SurfDailyQuizTheme {
    val colors: SurfDailyQuizColor = SurfDailyQuizColor()

    val typography: SurfDailyQuizTypography = SurfDailyQuizTypography()
}

val LocalSurfDailyQuizColors = staticCompositionLocalOf { SurfDailyQuizColor() }

val LocalSurfDailyQuizTypography = staticCompositionLocalOf { SurfDailyQuizTypography() }

@Composable
fun SurfDailyQuizTheme(
    darkTheme: Boolean = isSystemInDarkTheme() ,
    content: @Composable () -> Unit
) {
    val colors = SurfDailyQuizTheme.colors
    val typography = SurfDailyQuizTheme.typography

    CompositionLocalProvider(
        LocalSurfDailyQuizColors provides colors,
        LocalSurfDailyQuizTypography provides typography,
        content = content
    )
}