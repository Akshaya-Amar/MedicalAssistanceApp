package com.amar.medicalassistapp.ui.screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amar.medicalassistapp.ui.component.CategoryRow
import com.amar.medicalassistapp.ui.component.DayRow
import com.amar.medicalassistapp.ui.component.DoctorRow
import com.amar.medicalassistapp.ui.component.SearchBar
import com.amar.medicalassistapp.ui.component.TopBar
import com.amar.medicalassistapp.ui.component.UpcomingScheduleColumn
import com.amar.medicalassistapp.ui.model.DashboardData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
     val context = LocalContext.current
     var dashboardData by rememberSaveable { mutableStateOf<DashboardData?>(null) }

     LaunchedEffect(Unit) {
          dashboardData = fetchDashboardData(context)
     }

     var searchQuery by remember { mutableStateOf("") }

     Column(
          modifier = Modifier
               .fillMaxSize()
               .background(Color(0xFFEBEBEB))
               .padding(bottom = 80.dp)
          ,
     ) {

          TopBar()

          SearchBar(
               query = searchQuery,
               onQueryChange = { searchQuery = it }
          )

          Card(
               modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
               colors = CardDefaults.cardColors(containerColor = Color.White),
               elevation = CardDefaults.cardElevation(2.dp),
               shape = RoundedCornerShape(16.dp),
          ) {
               dashboardData?.let {
                    DayRow(it.dashboard.card.days)
                    Spacer(modifier = Modifier.height(12.dp))
                    DoctorRow(it.dashboard.card.specialists)
               }
          }

          dashboardData?.let {
               CategoryRow(it.dashboard.categories)
               UpcomingScheduleColumn(it.dashboard.upcomingSchedules)
          }
     }
}

private fun fetchDashboardData(context: Context): DashboardData {
     val json = context.assets.open("dashboard.json")
          .bufferedReader()
          .use { it.readText() }

     val listType = object : TypeToken<DashboardData>() {}.type
     return Gson().fromJson(json, listType)
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
     HomeScreen()
}