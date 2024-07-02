package com.allworkdone.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.allworkdone.composequadrant.ui.theme.ComposeQuadrantTheme
// Main activity class inheriting from ComponentActivity, which is part of Android's Jetpack Compose framework
class MainActivity : ComponentActivity() {

    // Overriding the onCreate method to set up the activity when it's created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        enableEdgeToEdge()

        // Setting the content view using Jetpack Compose
        setContent {
            // Applying the ComposeQuadrantTheme to the app
            ComposeQuadrantTheme {
                // Creating a Surface to hold the app's content, filling the max size of the screen
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Calling the ComposeQuadrantApp composable function to build the UI
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

// Composable function to build the quadrant layout
@Composable
fun ComposeQuadrantApp() {
    // Column to arrange children vertically and fill the maximum width
    Column(Modifier.fillMaxWidth()) {
        // First row, taking up 1 unit of the available vertical space
        Row(Modifier.weight(1f)) {
            // First quadrant: Text composable
            ComposeQuadrant(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFEADDFF),
                // Modifier to fill half the row's width and handle click events
                modifier = Modifier.weight(1f).clickable(onClick = {})
            )
            // Second quadrant: Image composable
            ComposeQuadrant(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color(0xFFD0BCFF),
                // Modifier to fill half the row's width and handle click events
                modifier = Modifier.weight(1f).clickable(onClick = {})
            )
        }
        // Second row, taking up 1 unit of the available vertical space
        Row(Modifier.weight(1f)) {
            // Third quadrant: Row composable
            ComposeQuadrant(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color(0xFFB69DF8),
                // Modifier to fill half the row's width and handle click events
                modifier = Modifier.weight(1f).clickable(onClick = {})
            )
            // Fourth quadrant: Column composable
            ComposeQuadrant(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color(0xFFF6EDFF),
                // Modifier to fill half the row's width and handle click events
                modifier = Modifier.weight(1f).clickable(onClick = {})
            )
        }
    }
}

// Composable function to create a quadrant with a title, description, and background color
@Composable
fun ComposeQuadrant(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    // Column to arrange children vertically, filling the available size and applying other modifiers
    Column(
        modifier = modifier
            .fillMaxSize()           // Fill the maximum available size
            .background(backgroundColor) // Set the background color
            .padding(16.dp),         // Add padding around the content
        verticalArrangement = Arrangement.Center, // Center children vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center children horizontally
    ) {
        // Text composable for the title, with padding below and bold font weight
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        // Text composable for the description, with justified text alignment
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantTheme() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ComposeQuadrantApp()
    }
}