package com.amar.medicalassistapp.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
     query: String,
     onQueryChange: (String) -> Unit
) {
     TextField(
          value = query,
          onValueChange = onQueryChange,
          placeholder = {
               Text(
                    text = "Search by doctor's name",
                    color = Color.Gray
               )
          },
          singleLine = true,
          trailingIcon = {
               Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Gray
               )
          },
          shape = RoundedCornerShape(50),
          colors = TextFieldDefaults.colors(
               focusedContainerColor = Color.White,
               unfocusedContainerColor = Color.White,
               disabledContainerColor = Color.White,
               errorContainerColor = Color.Red,
               focusedIndicatorColor = Color.Transparent,
               unfocusedIndicatorColor = Color.Transparent,
               disabledIndicatorColor = Color.Transparent,
               errorIndicatorColor = Color.Transparent
          ),
          modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp)
               .height(56.dp)
     )
}

@Preview(showBackground = true)
@Composable
private fun SearchBarPreview() {
     var searchQuery by remember { mutableStateOf("") }

     SearchBar(
          query = searchQuery,
          onQueryChange = { searchQuery = it }
     )
}