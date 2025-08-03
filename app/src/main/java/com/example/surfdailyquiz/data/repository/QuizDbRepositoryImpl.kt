package com.example.surfdailyquiz.data.repository

import com.example.surfdailyquiz.data.local.database.QuizWithAnswers
import com.example.surfdailyquiz.data.local.database.dao.QuizResultDao
import com.example.surfdailyquiz.data.local.database.entity.QuizResultEntity
import com.example.surfdailyquiz.data.local.database.entity.QuizTaskResultEntity
import com.example.surfdailyquiz.domain.usecase.QuizDbRepository
import jakarta.inject.Inject

class QuizDbRepositoryImpl @Inject constructor(
    private val quizResultDao: QuizResultDao
): QuizDbRepository {
    override suspend fun insertQuizWithAnswers(
        quiz: QuizResultEntity ,
        answers: List<QuizTaskResultEntity>
    ) {
        val quizId = quizResultDao.insertQuiz(quiz)
        val answersWithQuizId = answers.map {
            it.copy(quizResultId = quizId.toInt())
        }
        quizResultDao.insertAnswers(answersWithQuizId)
    }

    override suspend fun getLastQuizWithAnswers(): QuizWithAnswers? {
        return quizResultDao.getLastQuizWithAnswers()
    }

    override suspend fun getAllQuizzes(): List<QuizWithAnswers> {
        return quizResultDao.getAllQuizzesWithAnswers()
    }

    override suspend fun getQuizById(id: Int): QuizWithAnswers {
        return quizResultDao.getQuizWithAnswersById(id)
    }

    override suspend fun deleteQuiz(quiz: QuizWithAnswers) {
        quizResultDao.deleteQuizById(quiz.quiz.id)
    }
}