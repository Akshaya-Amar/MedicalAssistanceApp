package com.amar.medicalassistapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.amar.medicalassistapp.R
import com.amar.medicalassistapp.ui.model.Specialist

private val doctorColors = listOf(
     Color(0xFFFFEBF0),
     Color(0xFFE0F7FA),
     Color(0xFFFFF3E0),
     Color(0xFFE1BEE7)
)

@Composable
fun DoctorRow(doctorList: List<Specialist>) {
     LazyRow(
          modifier = Modifier
               .fillMaxWidth()
               .padding(top = 12.dp, bottom = 16.dp, start = 12.dp, end = 12.dp),
          horizontalArrangement = Arrangement.spacedBy(12.dp)
     ) {
          itemsIndexed(
               items = doctorList,
               key = { _, specialist ->
                    specialist.id
               }
          ) { index, specialist ->
               val bgColor = doctorColors[index % doctorColors.size]

               DoctorCard(
                    doctor = specialist,
                    backgroundColor = bgColor
               )
          }
     }
}

@Composable
fun DoctorCard(
     doctor: Specialist,
     backgroundColor: Color
) {
     val placeholderPainter = painterResource(R.drawable.baseline_account_circle_24)

     Card(
          modifier = Modifier
               .width(150.dp)
               .height(160.dp),
          colors = CardDefaults.cardColors(containerColor = backgroundColor),
          elevation = CardDefaults.cardElevation(2.dp),
          shape = RoundedCornerShape(16.dp),
     ) {
          Box(modifier = Modifier.fillMaxSize()) {
               AsyncImage(
                    model = doctor.profileImage,
                    contentDescription = "Doctor Profile Image",
                    modifier = Modifier
                         .padding(12.dp)
                         .size(60.dp)
                         .clip(CircleShape)
                         .align(Alignment.TopStart),
                    contentScale = ContentScale.Crop,
                    placeholder = placeholderPainter,
                    error = placeholderPainter
               )

               Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                         .align(Alignment.TopEnd)
                         .padding(top = 32.dp)
                         .background(
                              Color.White,
                              RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
                         )
                         .padding(horizontal = 6.dp, vertical = 2.dp)
               ) {
                    Icon(
                         imageVector = Icons.Default.Star,
                         contentDescription = "Rating",
                         tint = Color(0xFFFFC107),
                         modifier = Modifier.size(14.dp)
                    )

                    Spacer(Modifier.width(2.dp))

                    Text(
                         text = doctor.rating.toString(),
                         style = MaterialTheme.typography.titleSmall
                    )
               }

               Column(
                    modifier = Modifier
                         .align(Alignment.BottomStart)
                         .padding(start = 10.dp, bottom = 14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
               ) {
                    Text(
                         text = doctor.name,
                         fontWeight = FontWeight.Bold,
                         style = MaterialTheme.typography.titleMedium,
                         color = Color.Black
                    )
                    Text(
                         text = doctor.speciality,
                         style = MaterialTheme.typography.bodySmall,
                         color = Color.Gray
                    )
               }
          }
     }
}