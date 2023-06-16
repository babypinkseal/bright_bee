@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.brightbee.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.brightbee.R

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsContent()
        }
    }
}

@Composable
fun SettingsContent() {
    Scaffold(
        topBar = { AppTopBar() }
    ) {
        SettingsScreen()
    }
}

@Composable
fun AppTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.settings_title)) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(onClick = { /* Handle back button click */ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = stringResource(R.string.back))
            }
        },
        elevation = AppBarDefaults.TopAppBarElevation
    )
}

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.language_settings),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LanguageSettings()

        Text(
            text = stringResource(R.string.theme_settings),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        ThemeSettings()

        Text(
            text = stringResource(R.string.account_settings),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        AccountSettings()
    }
}

@Composable
fun LanguageSettings() {
    // Language settings UI goes here
    // Example: Drop-down menu for language selection
    // You can use the Settings API to save the selected language
}

@Composable
fun ThemeSettings() {
    // Theme settings UI goes here
    // Example: Radio buttons for theme selection (light, dark, etc.)
    // You can use the Settings API to save the selected theme
}

@Composable
fun AccountSettings() {
    // Account settings UI goes here
    // Example: Text fields for name, email, password, etc.
    // You can use the Settings API to save the account information
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}
