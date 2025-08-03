package com.example.surfdailyquiz.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surfdailyquiz.domain.models.QuizResult
import com.example.surfdailyquiz.domain.usecase.QuizDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FinishQuizViewModel @Inject constructor(
    private val repository: QuizDbRepository
) : ViewModel() {

    private val _quizResult = mutableStateOf<List<QuizResult>>(emptyList())
    val quizResult: State<List<QuizResult>> = _quizResult

    private val _quizDataTime = mutableStateOf<Pair<String, Long>?>(null)
    val quizDataTime: State<Pair<String, Long>?> = _quizDataTime

    fun loadLastQuizResult() {
        viewModelScope.launch {
            val lastQuizResult = repository.getLastQuizWithAnswers()
            lastQuizResult?.let {
                _quizDataTime.value = it.quiz.data to it.quiz.time // Хороший пример для Истории
                _quizResult.value = it.answers.map { answer ->
                    QuizResult(
                        question = answer.question ,
                        selectedAnswer = answer.selectedAnswer ,
                        correctAnswer = answer.correctedAnswer ,
                        incorrectAnswer = answer.incorrectAnswers ,
                        isCorrect = answer.isCorrect
                    )
                }
            }
        }
    }
}