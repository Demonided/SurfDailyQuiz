package com.example.surfdailyquiz.data.remote.model

import com.example.surfdailyquiz.data.remote.dto.QuestionDto
import com.example.surfdailyquiz.domain.models.Question

fun QuestionDto.toMapQuestion(): Question {
    return Question(
        type = this.type ,
        difficulty = this.difficulty ,
        category = this.category ,
        question = this.question ,
        correctAnswer = this.correctAnswer ,
        incorrectAnswers = this.incorrectAnswers
    )
}

fun Question.toMapQuestionDto(): QuestionDto {
    return QuestionDto(
        type = this.type ,
        difficulty = this.difficulty ,
        category = this.category ,
        question = this.question ,
        correctAnswer = this.correctAnswer ,
        incorrectAnswers = this.incorrectAnswers
    )
}

fun <T> List<QuestionDto>.toMapListQuestion() : List<Question> {
    return this.map { it.toMapQuestion() }
}