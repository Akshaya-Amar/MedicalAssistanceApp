package com.amar.medicalassistapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.amar.medicalassistapp.R

@Composable
fun TopBar() {
     Row(
          modifier = Modifier
               .fillMaxWidth()
               .padding(top = 32.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
     ) {
          AsyncImage(
               model = "https://t3.ftcdn.net/jpg/06/99/46/60/240_F_699466075_DaPTBNlNQTOwwjkOiFEoOvzDV0ByXR9E.jpg",
               contentDescription = "Profile",
               modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
               contentScale = ContentScale.Crop,
               placeholder = painterResource(R.drawable.baseline_account_circle_24),
               error = painterResource(R.drawable.baseline_account_circle_24),
          )

          AsyncImage(
               model = "https://static.vecteezy.com/system/resources/previews/029/881/131/non_2x/notification-bell-icon-free-png.png",
               contentDescription = "Notification Bell",
               modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.White)
//                    .clickable { onClick() }
                    .padding(16.dp),
               placeholder = painterResource(R.drawable.outline_notifications_24),
               error = painterResource(R.drawable.outline_notifications_24),
          )
     }
}

@Preview(showBackground = true)
@Composable
private fun TopBarPreview() {
     TopBar()
}