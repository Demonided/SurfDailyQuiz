package com.example.surfdailyquiz.presentation.ui.result

import com.example.surfdailyquiz.data.local.database.QuizWithAnswers

sealed interface HistoryUiState {
    object Empty: HistoryUiState
    data class Success(val history: List<QuizWithAnswers>): HistoryUiState
}