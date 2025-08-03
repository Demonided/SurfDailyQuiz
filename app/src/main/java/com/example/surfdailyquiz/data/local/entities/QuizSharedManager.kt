package com.example.surfdailyquiz.data.local.entities

import android.content.Context
import com.example.surfdailyquiz.domain.models.Question
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class QuizSharedManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs = context.getSharedPreferences("quizPrefs" , Context.MODE_PRIVATE)
    private val _questionFlow = MutableSharedFlow<List<Question>>(replay = 1)
    val questionFlow: SharedFlow<List<Question>> = _questionFlow.asSharedFlow()

    private val gson = Gson()

    fun saveQuestion(question: List<Question>) {
        val json = gson.toJson(question)
        prefs.edit().putString("question" , json).apply()
        _questionFlow.tryEmit(question)
    }

    fun loadQuestion(): List<Question> {
        val json = prefs.getString("question" , null) ?: return emptyList()
        return try {
            val type = object : TypeToken<List<Question>>() {}.type
            gson.fromJson(json , type)
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun refreshFlowPrefs() {
        val question = loadQuestion()
        if (question.isNotEmpty()) {
            _questionFlow.tryEmit(question)
        }
    }

}