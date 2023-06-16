package com.example.brightbee.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RatingBar(
    rating: Float,
    maxRating: Int,
    onRatingChanged: (Float) -> Unit
) {
    Row(modifier = Modifier.padding(vertical = 8.dp)) {
        repeat(maxRating) { index ->
            val starIcon: ImageVector = if (index < rating) {
                Icons.Filled.Star
            } else {
                Icons.Default.Star
            }
            Icon(
                imageVector = starIcon,
                contentDescription = null,
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .clickable { onRatingChanged(index + 1f) }
                    .padding(end = 4.dp)
            )
        }
    }
}
