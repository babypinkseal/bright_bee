package com.example.brightbee.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yourcompanyname.yourappname.R

class SurveyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    Scaffold(
        topBar = { AppTopBar() }
    ) {
        SurveyScreen()
    }
}

@Composable
fun AppTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.survey_title)) },
        backgroundColor = MaterialTheme.colors.primary,
        elevation = AppBarDefaults.TopAppBarElevation
    )
}

@Composable
fun SurveyScreen() {
    val questionList = generateQuestionList()

    Column(modifier = Modifier.padding(16.dp)) {
        for (question in questionList) {
            SurveyQuestion(question)
            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(
            onClick = { /* Handle submit button click */ },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = stringResource(R.string.submit_button))
        }
    }
}

@Composable
fun SurveyQuestion(question: String) {
    val selectedAnswer = remember { mutableStateOf(false) }

    Row(modifier = Modifier.fillMaxWidth()) {
        Checkbox(
            checked = selectedAnswer.value,
            onCheckedChange = { isChecked ->
                selectedAnswer.value = isChecked
            }
        )
        Text(
            text = question,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun SurveyScreenPreview() {
    SurveyScreen()
}

private fun generateQuestionList(): List<String> {
    // Return a list of survey questions
    return listOf(
        "I learn better by reading what the teacher writes on the blackboard.",
        "When I read the instructions, I remember them better.",
        "I understand more easily when I read instructions.",
        "It is easier for me to learn by reading than listening to someone.",
        "It is easier for me to learn by reading a textbook than listening to the teacher's explanation.",
        // Add more questions...
    )
}
