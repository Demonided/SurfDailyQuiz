package com.example.surfdailyquiz.di

import android.content.Context
import com.example.surfdailyquiz.data.local.entities.QuizSharedManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilModule {

    @Provides
    @Singleton
    fun provideQuizSharedManager(@ApplicationContext context: Context): QuizSharedManager {
        return QuizSharedManager(context)
    }
}