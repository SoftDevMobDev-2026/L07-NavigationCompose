package com.example.l07_navigationcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(imageKey: String, visited: Boolean, onBack: () -> Unit) {
    val location = when (imageKey) {
        "station" -> Location(name = "Glenferrie Station", author = "Ada May Plante", visited = visited)
        "college" -> Location(name = "Swinburne College", author = "Alfred Nicholas", visited = visited)
        "theatre" -> Location(name = "Swinburne Theatre", author = "Jean Fry", visited = visited)
        else -> Location(name = "", author = "", visited = visited)
    }

    val imageRes = when (imageKey) {
        "station" -> R.drawable.station
        "college" -> R.drawable.college
        "theatre" -> R.drawable.theatre
        else -> R.drawable.station
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = location.name,
            contentScale = ContentScale.Inside,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = location.name, style = MaterialTheme.typography.headlineMedium)
        Text(text = "Author: ${location.author}", style = MaterialTheme.typography.bodyLarge)
        Text(
            text = "Visited: ${if (location.visited) "Yes" else "No"}",
            style = MaterialTheme.typography.bodyLarge
        )

        Button(onClick = onBack) {
            Text("Back")
        }
    }
}