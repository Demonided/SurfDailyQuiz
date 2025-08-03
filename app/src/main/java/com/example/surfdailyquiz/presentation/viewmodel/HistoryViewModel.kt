package com.example.surfdailyquiz.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surfdailyquiz.data.local.database.QuizWithAnswers
import com.example.surfdailyquiz.domain.usecase.QuizDbRepository
import com.example.surfdailyquiz.presentation.ui.result.HistoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: QuizDbRepository
) : ViewModel() {

    private val _uiHistoryState = mutableStateOf<HistoryUiState>(HistoryUiState.Empty)
    val uiHistoryState: State<HistoryUiState> = _uiHistoryState

    init {
        loadAllQuizzes()
    }

    private fun loadAllQuizzes() {
        viewModelScope.launch {
            val quizzes = repository.getAllQuizzes()
            if (quizzes.isNullOrEmpty()) {
                _uiHistoryState.value = HistoryUiState.Empty
            } else {
                _uiHistoryState.value = HistoryUiState.Success(quizzes)
            }
        }
    }

    fun deleteQuiz(quiz: QuizWithAnswers) {
        viewModelScope.launch {
            repository.deleteQuiz(quiz)
            loadAllQuizzes()
        }
    }
}