package com.example.surfdailyquiz.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surfdailyquiz.data.local.entities.QuizSharedManager
import com.example.surfdailyquiz.domain.usecase.QuizApiRepository
import com.example.surfdailyquiz.presentation.state.QuizUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: QuizApiRepository ,
    private val sharedManager: QuizSharedManager
) : ViewModel() {

    private val _quizQuestionState = MutableStateFlow<QuizUiState>(QuizUiState.Idle)
    val quizQuestionState: StateFlow<QuizUiState> = _quizQuestionState.asStateFlow()

    fun fetchQuizQuestion() {
        viewModelScope.launch {
            _quizQuestionState.value = QuizUiState.Loading

            try {
                val questions = repository.getQuestions()
                sharedManager.saveQuestion(questions)
                _quizQuestionState.value = QuizUiState.Success(questions)
            } catch (e: Exception) {
                _quizQuestionState.value = QuizUiState.Error(e.message ?: "Ошибка! Попробуйте еще раз")
            }
        }
    }
}