package com.example.surfdailyquiz.domain.usecase

import com.example.surfdailyquiz.domain.models.Question

interface QuizApiRepository {
    suspend fun getQuestions(): List<Question>
}