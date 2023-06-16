@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.brightbee.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brightbee.R
import com.example.brightbee.data.SurveyResult
import kotlin.random.Random

class HistoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HistoryContent()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HistoryContent() {
    Scaffold(
        topBar = { HistoryAppTopBar() }
    ) {
        HistoryScreen()
    }
}

@Composable
fun HistoryAppTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.history_title)) },
        Modifier.background(color = Color.White)
        navigationIcon = {
            IconButton(onClick = { /* Handle back button click */ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = stringResource(R.string.back))
            }
        },
        elevation = AppBarDefaults.TopAppBarElevation
    )
}

@Composable
fun HistoryScreen() {
    val surveyResults = getSampleSurveyResults()

    if (surveyResults.isNotEmpty()) {
        LazyColumn {
            items(surveyResults) { surveyResult ->
                SurveyResultItem(surveyResult)
            }
        }
    } else {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(R.string.history_no_results))
        }
    }
}

@Composable
fun SurveyResultItem(surveyResult: SurveyResult) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(R.string.history_survey_date, surveyResult.date))
            Text(text = stringResource(R.string.history_score, surveyResult.score))
            // Add more details about the survey result, such as learning style preferences
            // You can also add buttons or actions to delete or share the survey result
            IconButton(onClick = { /* Handle delete button click */ }) {
                Icon(Icons.Filled.Delete, contentDescription = stringResource(R.string.delete))
            }
        }
    }
}

fun getSampleSurveyResults(): SurveyResult {
    // Create a list of sample survey questions
    val questions = listOf(
        SurveyQuestion(1, "I learn better by reading what the teacher writes on the blackboard."),
        SurveyQuestion(2, "When I read the instructions, I remember them better."),
        SurveyQuestion(3, "I understand more easily when I read instructions."),
        // Add more questions here...
    )

    // Create an empty map to store the user's responses
    val responses = mutableMapOf<Int, Boolean>()

    // Simulate random user responses for each question
    for (question in questions) {
        val response = Random.nextBoolean()
        responses[question.id] = response
    }

    // Create and return a survey result with the sample responses
    return SurveyResult(responses)
}

@Preview
@Composable
fun HistoryScreenPreview() {
    HistoryScreen()
}