package com.amar.medicalassistapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.amar.medicalassistapp.R
import com.amar.medicalassistapp.ui.model.Category

@Composable
fun CategoryRow(categoryList: List<Category>) {
     LazyRow(
          modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp),
          horizontalArrangement = Arrangement.spacedBy(12.dp)
     ) {
          items(categoryList) {
               Category(
                    name = it.title,
                    imageUrl = it.icon
               )
          }
     }
}

@Composable
fun Category(
     name: String,
     imageUrl: String
) {
     Row(
          modifier = Modifier
               .clip(RoundedCornerShape(36.dp))
               .background(Color.White)
               .padding(start = 4.dp, end = 16.dp, top = 6.dp, bottom = 6.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(8.dp)
     ) {
          AsyncImage(
               model = imageUrl,
               contentDescription = name,
               modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape),
               placeholder = painterResource(R.drawable.baseline_account_circle_24),
               error = painterResource(R.drawable.baseline_account_circle_24)
          )

          Text(
               text = name,
               style = MaterialTheme.typography.bodyLarge,
          )
     }
}

@Preview(showBackground = true)
@Composable
private fun CategoryPreview() {
     Category("", "")
}