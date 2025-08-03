package com.example.surfdailyquiz.data.remote.dto

import com.google.gson.annotations.SerializedName

data class QuestionDto(
    val type: String,
    val difficulty: String,
    val category: String,
    val question: String,
    @SerializedName("correct_answer")
    val correctAnswer: String,
    @SerializedName("incorrect_answers")
    val incorrectAnswers: List<String>
)