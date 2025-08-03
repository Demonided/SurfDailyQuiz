package com.example.surfdailyquiz.data.local.database

import androidx.room.Embedded
import androidx.room.Relation
import com.example.surfdailyquiz.data.local.database.entity.QuizResultEntity
import com.example.surfdailyquiz.data.local.database.entity.QuizTaskResultEntity

data class QuizWithAnswers(
    @Embedded val quiz: QuizResultEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "quizResultId"
    )
    val answers: List<QuizTaskResultEntity>
)