package com.example.surfdailyquiz.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.surfdailyquiz.data.local.database.dao.QuizResultDao
import com.example.surfdailyquiz.data.local.database.entity.QuizResultEntity
import com.example.surfdailyquiz.data.local.database.entity.QuizTaskResultEntity

@Database(
    entities = [QuizResultEntity::class , QuizTaskResultEntity::class] ,
    version = 1 ,
    exportSchema = false
)
@TypeConverters(TypeConvertersString::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun quizResultDao(): QuizResultDao
}