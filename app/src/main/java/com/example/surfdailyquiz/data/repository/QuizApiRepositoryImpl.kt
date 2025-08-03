package com.example.surfdailyquiz.data.repository

import com.example.surfdailyquiz.data.remote.api.ApiQuizService
import com.example.surfdailyquiz.data.remote.model.toMapListQuestion
import com.example.surfdailyquiz.domain.models.Question
import com.example.surfdailyquiz.domain.usecase.QuizApiRepository
import jakarta.inject.Inject

class QuizApiRepositoryImpl @Inject constructor(
    private val apiQuizService: ApiQuizService
) : QuizApiRepository {

    override suspend fun getQuestions(): List<Question> {
        val response = apiQuizService.getQuestions()
        return response.results.toMapListQuestion<Question>()
    }
}