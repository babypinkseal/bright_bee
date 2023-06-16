package com.example.brightbee.data

data class SurveyResponse(
    val id: String,
    val userId: String,
    val answers: List<Boolean>
)

