package com.example.surfdailyquiz.domain.models

data class QuizResult(
    val question: String ,
    val selectedAnswer: String ,
    val correctAnswer: String ,
    val incorrectAnswer: List<String> ,
    val isCorrect: Boolean
)
