package com.example.l07_navigationcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MainScreen(
    stationVisited: Boolean,
    collegeVisited: Boolean,
    theatreVisited: Boolean,
    onImageClick: (String) -> Unit,
    onReset: () -> Unit
) {
    var currentImage by rememberSaveable { mutableStateOf("station") }

    Column(modifier = Modifier.fillMaxSize()) {

        val imageRes = when (currentImage) {
            "station" -> R.drawable.station
            "college" -> R.drawable.college
            "theatre" -> R.drawable.theatre
            else -> R.drawable.station
        }

        val currentVisited = when (currentImage) {
            "station" -> stationVisited
            "college" -> collegeVisited
            "theatre" -> theatreVisited
            else -> stationVisited
        }

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "station",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f)
                .clickable { onImageClick(currentImage) }
        )

        Text(
            text = "Visited: ${if (currentVisited) "Yes" else "No"}",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = { currentImage = "station" },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text("Station")
            }

            Button(
                onClick = { currentImage = "college" },
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                Text("College")
            }

            Button(
                onClick = { currentImage = "theatre" },
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                Text("Theatre")
            }
            Button(
                onClick = { currentImage = "station"},
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                Text("Reset")
            }
        }

        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}