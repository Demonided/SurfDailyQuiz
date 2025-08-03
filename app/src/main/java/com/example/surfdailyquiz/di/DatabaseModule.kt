package com.example.surfdailyquiz.di

import android.content.Context
import androidx.room.Room
import com.example.surfdailyquiz.data.local.database.AppDataBase
import com.example.surfdailyquiz.data.local.database.dao.QuizResultDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "quiz_result"
        ).build()
    }

    @Provides
    fun provideQuizResultDao(database: AppDataBase) : QuizResultDao{
        return database.quizResultDao()
    }
}