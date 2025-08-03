package com.example.surfdailyquiz.domain.models

import com.example.surfdailyquiz.data.remote.dto.QuestionDto
import com.google.gson.annotations.SerializedName

data class QuestionResponse(
    @SerializedName("response_code")
    val responseCode: Int,
    val results: List<QuestionDto>
)
