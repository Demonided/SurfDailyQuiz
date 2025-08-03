package com.example.surfdailyquiz.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_result")
data class QuizResultEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val data: String,
    val time: Long,
    val countCorrect: Int,
    val category: String,
    val difficulty: String,
)

