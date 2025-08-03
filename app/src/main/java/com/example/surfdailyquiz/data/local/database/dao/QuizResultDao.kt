package com.example.surfdailyquiz.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.surfdailyquiz.data.local.database.QuizWithAnswers
import com.example.surfdailyquiz.data.local.database.entity.QuizResultEntity
import com.example.surfdailyquiz.data.local.database.entity.QuizTaskResultEntity

@Dao
interface QuizResultDao {

    @Insert
    suspend fun insertQuiz(quiz: QuizResultEntity): Long

    @Insert
    suspend fun insertAnswers(answers: List<QuizTaskResultEntity>)

    @Transaction
    @Query("SELECT * FROM quiz_result ORDER BY time DESC")
    suspend fun getAllQuizzesWithAnswers(): List<QuizWithAnswers>

    @Transaction
    @Query("SELECT * FROM quiz_result WHERE id = :quizId")
    suspend fun getQuizWithAnswersById(quizId: Int): QuizWithAnswers

    @Transaction
    @Query("SELECT * FROM quiz_result ORDER BY id DESC LIMIT 1")
    suspend fun getLastQuizWithAnswers(): QuizWithAnswers?

    @Transaction
    suspend fun deleteQuizWithAnswersById(quizId: Int) {
        deleteQuizById(quizId)
        deleteAnswersByQuizId(quizId)
    }

    @Query("DELETE FROM quiz_result WHERE id = :quizId")
    suspend fun deleteQuizById(quizId: Int)

    @Query("DELETE FROM quiz_task_result WHERE id = :quizId")
    suspend fun deleteAnswersByQuizId(quizId: Int)

}