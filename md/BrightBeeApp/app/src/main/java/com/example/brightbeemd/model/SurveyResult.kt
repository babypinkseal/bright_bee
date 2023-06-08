package com.example.brightbeemd.model

data class SurveyResult(
    val surveyId: Int,
    val date: String,
    val score: Float,
    val recommendations: List<String>
)

