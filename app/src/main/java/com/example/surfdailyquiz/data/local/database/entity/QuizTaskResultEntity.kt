package com.example.surfdailyquiz.data.local.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "quiz_task_result" ,
    foreignKeys = [ForeignKey(
        entity = QuizResultEntity::class ,
        parentColumns = ["id"] ,
        childColumns = ["quizResultId"] ,
        onDelete = ForeignKey.CASCADE
    )] ,
    indices = [Index(value = ["quizResultId"])]
)
data class QuizTaskResultEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0 ,
    val quizResultId: Int ,
    val question: String ,
    val correctedAnswer: String ,
    val selectedAnswer: String ,
    val incorrectAnswers: List<String> ,
    val isCorrect: Boolean
)
