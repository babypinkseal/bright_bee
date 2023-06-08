package com.example.brightbeemd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BrightBeeViewModel : ViewModel() {
    private val _learningStyle = MutableLiveData<LearningStyle>()
    val learningStyle: LiveData<LearningStyle> get() = _learningStyle

    fun calculateLearningStyle(answers: List<Boolean>) {
        val visualCount = answers.subList(0, 5).count { it }
        val auditoryCount = answers.subList(5, 10).count { it }
        val kinestheticCount = answers.subList(10, 14).count { it }

        val learningStyle = LearningStyle(visualCount, auditoryCount, kinestheticCount)
        _learningStyle.value = learningStyle
    }
}

data class LearningStyle(
    val visualCount: Int,
    val auditoryCount: Int,
    val kinestheticCount: Int
) {
    val totalQuestions: Int = 14
}
