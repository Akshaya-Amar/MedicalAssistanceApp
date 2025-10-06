package com.amar.medicalassistapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MessageScreen(modifier: Modifier = Modifier) {
     Column(
          modifier = Modifier
               .fillMaxSize()
               .background(Color.Cyan),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
     ) {
          Text(
               text = "Message Screen",
               color = Color.White,
               style = MaterialTheme.typography.headlineMedium
          )
     }
}

@Preview(showBackground = true)
@Composable
private fun MessageScreenPreview() {
     MessageScreen()
}