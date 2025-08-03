package com.example.surfdailyquiz.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surfdailyquiz.data.local.database.entity.QuizResultEntity
import com.example.surfdailyquiz.data.local.database.entity.QuizTaskResultEntity
import com.example.surfdailyquiz.data.local.entities.QuizSharedManager
import com.example.surfdailyquiz.domain.models.Question
import com.example.surfdailyquiz.domain.usecase.QuizDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val sharedManager: QuizSharedManager,
    private val repositoryDb: QuizDbRepository
) : ViewModel() {
    var questions: List<Question> by mutableStateOf(emptyList())
        private set

    var selectedAnswer: MutableList<Pair<Question, String>> = mutableListOf()

    init {
        viewModelScope.launch {
            sharedManager.questionFlow.collect {
                questions = it
            }
        }
        sharedManager.refreshFlowPrefs()
    }

    fun saveAnswer(question: Question, selected: String) {
        selectedAnswer.removeAll { it.first == question }
        selectedAnswer.add(Pair(question, selected))
    }

    fun saveQuizResult(
        category: String,
        difficulty: String,
    ) {
        viewModelScope.launch {
            val correctCount = selectedAnswer.count { it.first.correctAnswer == it.second }

            val quizEntity = QuizResultEntity(
                data = System.currentTimeMillis().toString() ,
                time = System.currentTimeMillis() ,
                countCorrect = correctCount ,
                category = category ,
                difficulty = difficulty
            )

            val answer = selectedAnswer.map {
                QuizTaskResultEntity(
                    quizResultId = 0,
                    question = it.first.question,
                    correctedAnswer = it.first.correctAnswer,
                    selectedAnswer = it.second,
                    incorrectAnswers = it.first.incorrectAnswers,
                    isCorrect = it.first.correctAnswer == it.second
                )
            }

            repositoryDb.insertQuizWithAnswers(quizEntity, answer)
        }
    }
}