package com.example.surfdailyquiz.domain.usecase

import com.example.surfdailyquiz.data.local.database.QuizWithAnswers
import com.example.surfdailyquiz.data.local.database.entity.QuizResultEntity
import com.example.surfdailyquiz.data.local.database.entity.QuizTaskResultEntity
import com.example.surfdailyquiz.domain.models.QuizResult

interface QuizDbRepository {
    suspend fun insertQuizWithAnswers(
        quiz: QuizResultEntity ,
        answers: List<QuizTaskResultEntity>
    )

    suspend fun getLastQuizWithAnswers(): QuizWithAnswers?
    suspend fun getAllQuizzes(): List<QuizWithAnswers>
    suspend fun getQuizById(id: Int): QuizWithAnswers
    suspend fun deleteQuiz(quiz: QuizWithAnswers)
}