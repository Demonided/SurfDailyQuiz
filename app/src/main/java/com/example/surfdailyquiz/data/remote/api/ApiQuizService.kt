package com.example.surfdailyquiz.data.remote.api

import com.example.surfdailyquiz.domain.models.QuestionResponse
import retrofit2.http.GET

interface ApiQuizService {

    @GET("api.php?amount=5")
    suspend fun getQuestions(): QuestionResponse
}