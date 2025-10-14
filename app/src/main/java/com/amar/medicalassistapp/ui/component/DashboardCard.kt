package com.amar.medicalassistapp.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.amar.medicalassistapp.ui.model.CardData

@Composable
fun DashboardCard(cardData: CardData) {
     Card(
          modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          elevation = CardDefaults.cardElevation(2.dp),
          shape = RoundedCornerShape(16.dp),
     ) {
          DayRow(cardData.days)
          DoctorRow(cardData.specialists)
     }
}