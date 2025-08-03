package com.example.surfdailyquiz.di

import com.example.surfdailyquiz.data.repository.QuizApiRepositoryImpl
import com.example.surfdailyquiz.data.repository.QuizDbRepositoryImpl
import com.example.surfdailyquiz.domain.usecase.QuizApiRepository
import com.example.surfdailyquiz.domain.usecase.QuizDbRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindQuizRepository(
        impl: QuizApiRepositoryImpl
    ): QuizApiRepository

    @Binds
    abstract fun bindQuizDbRepository(
        impl: QuizDbRepositoryImpl
    ): QuizDbRepository
}