package com.example.brightbee.data

data class SurveyQuestion(
    val id: Int,
    val text: String,
    val learningStyle: LearningStyle
) {
    companion object {
        private val surveyQuestions = listOf(
            SurveyQuestion(1, "I learn better by reading what the teacher writes on the blackboard.", LearningStyle.VISUAL),
            SurveyQuestion(2, "When I read the instructions, I remember them better.", LearningStyle.VISUAL),
            SurveyQuestion(3, "I understand more easily when I read instructions.", LearningStyle.VISUAL),
            SurveyQuestion(4, "It is easier for me to learn by reading than listening to someone.", LearningStyle.VISUAL),
            SurveyQuestion(5, "It is easier for me to learn by reading a textbook than listening to the teacher's explanation.", LearningStyle.VISUAL),
            SurveyQuestion(6, "It is easier for me to understand something when the teacher gives instructions.", LearningStyle.AUDITORY),
            SurveyQuestion(7, "When someone tells me how to do something in class, it is easier for me to learn.", LearningStyle.AUDITORY),
            SurveyQuestion(8, "It is easier for me to remember what I hear than when I read it.", LearningStyle.AUDITORY),
            SurveyQuestion(9, "It is easier for me to learn in class when the teacher gives explanations.", LearningStyle.AUDITORY),
            SurveyQuestion(10, "I learn better in class when I listen to someone.", LearningStyle.AUDITORY),
            SurveyQuestion(11, "I prefer to learn by doing in class.", LearningStyle.KINESTHETIC),
            SurveyQuestion(12, "When I practice in class, it is easier for me to understand.", LearningStyle.KINESTHETIC),
            SurveyQuestion(13, "I like to study in class by doing experiments/practices.", LearningStyle.KINESTHETIC),
            SurveyQuestion(14, "I understand the subject matter better in class when I participate in role plays.", LearningStyle.KINESTHETIC),
            SurveyQuestion(15, "I am more interested when I participate in role plays.", LearningStyle.KINESTHETIC)
        )

        fun getQuestionById(questionId: Int): SurveyQuestion? {
            return surveyQuestions.find { it.id == questionId }
        }
    }
}

