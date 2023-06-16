package com.example.brightbee.data

data class SurveyResult(
    val responses: Map<Int, Boolean>
) {
    val visualScore: Int
        get() = calculateScore(LearningStyle.VISUAL)

    val auditoryScore: Int
        get() = calculateScore(LearningStyle.AUDITORY)

    val kinestheticScore: Int
        get() = calculateScore(LearningStyle.KINESTHETIC)

    private fun calculateScore(learningStyle: LearningStyle): Int {
        val matchingResponses = responses.filter { it.value }
        val matchingQuestions = matchingResponses.keys.mapNotNull { questionId ->
            SurveyQuestion.getQuestionById(questionId)
        }

        val styleCount = matchingQuestions.count { it.learningStyle == learningStyle }
        val totalQuestions = matchingQuestions.size

        return if (totalQuestions > 0) {
            (styleCount.toDouble() / totalQuestions.toDouble() * 100).toInt()
        } else {
            0
        }
    }
}

