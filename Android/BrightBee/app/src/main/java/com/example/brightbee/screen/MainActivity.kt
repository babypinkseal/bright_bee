@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.brightbee.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainContent() {
    Scaffold(
        topBar = { MainAppTopBar() }
    ) {
        MainScreen()
    }
}

@Composable
fun MainAppTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        Modifier.background(color = Color.White)
//        backgroundColor = MaterialTheme.colorS.primary,
//        elevation = AppBarDefaults.TopAppBarElevation
    )
}

@Composable
fun MainScreen(surveys: List<Survey>, learningMaterials: List<LearningMaterial>) {
    LazyColumn {
        item {
            Text(text = "Survei Tersedia")
        }

        items(surveys) { survey ->
            SurveyCard(survey)
        }

        item {
            Text(text = "Materi Pembelajaran Terbaru")
        }

        items(learningMaterials) { material ->
            LearningMaterialCard(material)
        }
    }
}


@Composable
fun SurveyCard(survey: Survey) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = survey.title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = survey.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* Handle klik survei */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Mulai Survei")
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
