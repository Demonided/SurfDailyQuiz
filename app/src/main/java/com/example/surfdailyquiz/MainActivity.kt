package com.example.surfdailyquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.surfdailyquiz.navhost.Home
import com.example.surfdailyquiz.navhost.SurfDailyQuizNavScreen
import com.example.surfdailyquiz.presentation.ui.theme.SurfDailyQuizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SurfDailyQuizTheme {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(SurfDailyQuizTheme.colors.blueLight)
                    ) {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = Color.Transparent
                        ) {
                            SurfDailyQuizNavScreen(
                                startDestination = Home.route,
                            )
                        }
                    }
            }
        }
    }
}
