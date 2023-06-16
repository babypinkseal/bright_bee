package com.example.brightbee.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorSnackbar(
    errorMessage: String,
    onDismiss: () -> Unit
) {
    Snackbar(
        modifier = Modifier.padding(16.dp),
        backgroundColor = MaterialTheme.colors.error,
        action = {
            TextButton(onClick = onDismiss) {
                Text(text = "Dismiss", color = MaterialTheme.colors.onError)
            }
        },
        content = {
            Text(text = errorMessage, color = MaterialTheme.colors.onError)
        },
        duration = SnackbarDuration.Short
    )
}
