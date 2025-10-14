package com.amar.medicalassistapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amar.medicalassistapp.ui.model.Day

@Composable
fun DayRow(days: List<Day>) {
     var selectedDay by rememberSaveable { mutableStateOf("Wed") }

     Row(
          modifier = Modifier
               .fillMaxWidth()
               .padding(12.dp),
          horizontalArrangement = Arrangement.SpaceEvenly
     ) {
          days.forEach { calendarDay ->
               DayDateChip(
                    day = calendarDay.day,
                    date = calendarDay.date.toString(),
                    isSelected = selectedDay == calendarDay.day,
                    onClick = {
                         if (selectedDay != calendarDay.day) {
                              selectedDay = calendarDay.day
                         }
                    }
               )
          }
     }
}

@Composable
fun DayDateChip(
     day: String,
     date: String,
     isSelected: Boolean,
     onClick: () -> Unit
) {
     val backgroundColor = if (isSelected) Color(0xFFFFC107) else Color(0xEBF7F7F7)
     val textColor = if (isSelected) Color.White else Color.Gray
     Column(
          modifier = Modifier
               .height(88.dp)
               .width(44.dp)
               .clip(RoundedCornerShape(percent = 50))
               .background(backgroundColor)
               .clickable { onClick() }
               .padding(top = 12.dp, bottom = 6.dp),
          verticalArrangement = Arrangement.SpaceBetween,
          horizontalAlignment = Alignment.CenterHorizontally
     ) {
          Text(
               text = day,
               color = textColor,
               style = MaterialTheme.typography.bodySmall,
               fontWeight = FontWeight.Bold
          )

          Box(
               modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape)
                    .background(Color.White),
               contentAlignment = Alignment.Center
          ) {
               Text(
                    text = date,
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
               )
          }
     }
}

@Preview(showSystemUi = true)
@Composable
fun DayDateChipPreview() {
     DayDateChip(day = "Wed", date = "18", isSelected = true, {})
}