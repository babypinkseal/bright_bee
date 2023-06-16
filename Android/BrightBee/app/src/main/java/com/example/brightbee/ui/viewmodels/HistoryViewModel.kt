package com.example.brightbee.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.brightbee.data.SurveyResponse

class HistoryViewModel : ViewModel() {
    private val _surveyResponses = MutableLiveData<List<SurveyResponse>>()
    val surveyResponses: LiveData<List<SurveyResponse>> = _surveyResponses

    // TODO: Implement logic to fetch survey responses from the repository and update the LiveData
    fun fetchSurveyResponses() {
        // Fetch survey responses from the repository
        val fetchedSurveyResponses = // TODO: Fetch survey responses
            _surveyResponses.value = fetchedSurveyResponses
    }

    // TODO: Implement logic to delete a survey response from the repository
    fun deleteSurveyResponse(surveyResponse: SurveyResponse) {
        // Delete survey response from the repository
        // TODO: Delete survey response
    }
}
