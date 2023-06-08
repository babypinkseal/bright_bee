@file:OptIn(ExperimentalMaterialApi::class)

package com.example.brightbeemd

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brightbeemd.model.Course
import com.example.brightbeemd.model.SurveyResult
import com.example.brightbeemd.ui.theme.BrightBeeMDTheme

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to Learning Style App!",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { /* Navigate to the survey screen */ },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(text = "Take the Survey")
        }
        Button(
            onClick = { /* Navigate to the search screen */ },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(text = "Search Learning Materials")
        }
        // Add navigation drawer and handle navigation actions
    }
}

@Composable
fun SurveyScreen(
    questions: List<String>,
    onAnswerSelected: (Int, Boolean) -> Unit,
    onSubmitSurvey: () -> Unit
) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    val questionCount = questions.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Learning Style Survey",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = questions[currentQuestionIndex],
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { onAnswerSelected(currentQuestionIndex, true) }
            ) {
                Text(text = "True")
            }
            Button(
                onClick = { onAnswerSelected(currentQuestionIndex, false) }
            ) {
                Text(text = "False")
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        if (currentQuestionIndex < questionCount - 1) {
            Button(
                onClick = { currentQuestionIndex++ },
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(text = "Next Question")
            }
        } else {
            Button(
                onClick = onSubmitSurvey,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(text = "Submit Survey")
            }
        }
    }
}

@Composable
fun CourseScreen(
    courses: List<Course>,
    onCourseSelected: (Course) -> Unit,
    onSearch: (String) -> Unit
) {
    val searchText = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            label = { Text(text = "Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        LazyColumn {
            items(courses) { course ->
                CourseItem(
                    course = course,
                    onItemClick = { onCourseSelected(course) }
                )
            }
        }
    }

    LaunchedEffect(searchText.value) {
        onSearch(searchText.value)
    }
}

@Composable
fun CourseItem(
    course: Course,
    onItemClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        onClick = onItemClick
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = course.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = course.author,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = course.description,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
fun HistoryScreen(
    surveyResults: List<SurveyResult>,
    onSurveyResultSelected: (SurveyResult) -> Unit,
    onDeleteSurveyResult: (SurveyResult) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Survey History",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        if (surveyResults.isNotEmpty()) {
            LazyColumn {
                items(surveyResults) { result ->
                    SurveyResultItem(
                        surveyResult = result,
                        onItemClick = { onSurveyResultSelected(result) },
                        onDeleteClick = { onDeleteSurveyResult(result) }
                    )
                }
            }
        } else {
            Text(
                text = "No survey results available.",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun SurveyResultItem(
    surveyResult: SurveyResult,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        onClick = onItemClick
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = surveyResult.date,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Score: ${surveyResult.score}",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(
                    onClick = onDeleteClick,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(text = "Delete")
                }
            }
        }
    }
}

@Composable
fun SettingsScreen(
    languageOptions: List<String>,
    selectedLanguage: String,
    onLanguageSelected: (String) -> Unit,
    themeOptions: List<String>,
    selectedTheme: String,
    onThemeSelected: (String) -> Unit,
    onProfileEdit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        SettingItem(
            label = "Language",
            selectedOption = selectedLanguage,
            options = languageOptions,
            onOptionSelected = onLanguageSelected
        )

        SettingItem(
            label = "Theme",
            selectedOption = selectedTheme,
            options = themeOptions,
            onOptionSelected = onThemeSelected
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onProfileEdit() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Edit Profile")
        }
    }
}

@Composable
fun SettingItem(
    label: String,
    selectedOption: String,
    options: List<String>,
    onOptionSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        DropdownMenu(
            expanded = false,
            onDismissRequest = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(option)
                    }
                ) {
                    Text(text = option)
                }
            }
        }
    }
}

@Composable
fun AuthenticationScreen(
    onSignIn: (String, String) -> Unit,
    onSignUp: () -> Unit,
    onForgotPassword: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Authentication",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Email input
        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password input
        var password by remember { mutableStateOf("") }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Sign in button
        Button(
            onClick = { onSignIn(email, password) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign In")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Sign up button
        TextButton(
            onClick = onSignUp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign Up")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Forgot password button
        TextButton(
            onClick = onForgotPassword,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Forgot Password?")
        }
    }
}

@Composable
fun PasswordResetScreen(
    onResetPassword: (String) -> Unit,
    onSignIn: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Reset Password",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Email input
        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Reset password button
        Button(
            onClick = { onResetPassword(email) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Reset Password")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Sign in button
        TextButton(
            onClick = onSignIn,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign In")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    BrightBeeMDTheme {
        MainScreen()
    }
}

