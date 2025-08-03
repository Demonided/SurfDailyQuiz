package com.example.surfdailyquiz.presentation.state

import com.example.surfdailyquiz.domain.models.Question

sealed class QuizUiState {
    object Idle : QuizUiState()
    object Loading : QuizUiState()
    data class Success(val questions: List<Question>) : QuizUiState()
    data class Error(val message: String) : QuizUiState()
}