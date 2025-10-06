package com.amar.medicalassistapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.amar.medicalassistapp.R
import com.amar.medicalassistapp.ui.model.UpcomingSchedule

@Composable
fun UpcomingScheduleColumn(upcomingSchedules: List<UpcomingSchedule>) {
     LazyColumn {
          items(upcomingSchedules) { doctor ->
               UpcomingScheduleItem(
                    doctorName = doctor.doctorName,
                    specialization = doctor.speciality,
                    imageUrl = doctor.profileImage,
                    schedule = doctor.time,
                    onCallClick = {},
                    onChatClick = {}
               )
          }
     }
}

@Composable
fun UpcomingScheduleItem(
     doctorName: String,
     specialization: String,
     imageUrl: String,
     schedule: String,
     onChatClick: () -> Unit,
     onCallClick: () -> Unit
) {
     Card(
          modifier = Modifier
               .fillMaxWidth()
               .padding(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          elevation = CardDefaults.cardElevation(2.dp),
          shape = RoundedCornerShape(16.dp),
     ) {
          Column(
               modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
          ) {
               Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
               ) {
                    AsyncImage(
                         model = imageUrl,
                         contentDescription = "Doctor Image",
                         modifier = Modifier
                              .size(60.dp)
                              .clip(CircleShape),
                         contentScale = ContentScale.Crop,
                         placeholder = painterResource(R.drawable.baseline_account_circle_24),
                         error = painterResource(R.drawable.baseline_account_circle_24),
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(modifier = Modifier.weight(1f)) {
                         Text(
                              text = doctorName,
                              fontWeight = FontWeight.Bold,
                              style = MaterialTheme.typography.titleMedium,
                              color = Color.Black
                         )
                         Text(
                              text = specialization,
                              style = MaterialTheme.typography.bodySmall,
                              color = Color.Gray
                         )
                    }

                    ActionIconButton(
                         icon = Icons.Default.Email,
                         contentDescription = "Chat",
                         backgroundColor = Color(0xFFE0F2F1),
                         tintColor = Color(0xFF2180F3),
                         onClick = onChatClick
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    ActionIconButton(
                         icon = Icons.Default.Call,
                         contentDescription = "Call",
                         backgroundColor = Color(0xFFE8F5E9),
                         tintColor = Color(0xFF4CAF50),
                         onClick = onCallClick
                    )
               }

               Spacer(modifier = Modifier.height(16.dp))

               Box(
                    modifier = Modifier
                         .fillMaxWidth()
                         .clip(RoundedCornerShape(24.dp))
                         .background(Color(0xFFF7F7F7))
                         .padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center
               ) {
                    Text(
                         text = schedule,
                         fontWeight = FontWeight.Medium,
                         style = MaterialTheme.typography.bodyMedium,
                         color = Color.Black
                    )
               }
          }
     }
}

@Preview(showBackground = true)
@Composable
private fun UpcomingSchedulePreview() {
     UpcomingScheduleItem(
          doctorName = "Dr. Lailas Russell",
          specialization = "Dermatologist Specialist",
          imageUrl = "https://via.placeholder.com/150",
          schedule = "20 September - 12:30 - 10:30 PM",
          onChatClick = {},
          onCallClick = {}
     )
}

@Composable
fun ActionIconButton(
     icon: ImageVector,
     contentDescription: String,
     backgroundColor: Color,
     tintColor: Color,
     onClick: () -> Unit
) {
     IconButton(
          onClick = onClick,
          modifier = Modifier
               .size(36.dp)
               .background(backgroundColor, CircleShape)
     ) {
          Icon(
               imageVector = icon,
               contentDescription = contentDescription,
               tint = tintColor
          )
     }
}