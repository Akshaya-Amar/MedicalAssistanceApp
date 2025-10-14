package com.amar.medicalassistapp.ui.screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amar.medicalassistapp.ui.component.CategoryRow
import com.amar.medicalassistapp.ui.component.DashboardCard
import com.amar.medicalassistapp.ui.component.SearchBar
import com.amar.medicalassistapp.ui.component.TopBar
import com.amar.medicalassistapp.ui.component.UpcomingScheduleItem
import com.amar.medicalassistapp.ui.model.DashboardData
import com.google.gson.Gson

@Composable
fun HomeScreen() {
     val context = LocalContext.current
     var dashboardData by rememberSaveable { mutableStateOf<DashboardData?>(null) }
     var searchQuery by rememberSaveable { mutableStateOf("") }

     LaunchedEffect(Unit) {
          dashboardData = fetchDashboardData(context)
     }

     Column(
          modifier = Modifier
               .fillMaxSize()
               .background(Color(0xFFF0F0F0))
     ) {
          TopBar()

          SearchBar(
               query = searchQuery,
               onQueryChange = { searchQuery = it }
          )

          DashboardList(dashboardData)
     }
}

@Composable
fun DashboardList(dashboardData: DashboardData?) {
     dashboardData?.let { data ->
          LazyColumn(
               modifier = Modifier.fillMaxSize(),
               contentPadding = PaddingValues(bottom = 80.dp)
          ) {
               item {
                    DashboardCard(data.dashboard.card)
               }

               item {
                    CategoryRow(data.dashboard.categories)
               }

               items(
                    items = data.dashboard.upcomingSchedules,
                    key = { it.id }
               ) { schedule ->
                    UpcomingScheduleItem(
                         upcomingSchedule = schedule,
                         onCallClick = {},
                         onChatClick = {}
                    )
               }
          }
     }
}

private fun fetchDashboardData(context: Context): DashboardData {
     val json = context.assets.open("dashboard.json")
          .bufferedReader()
          .use { it.readText() }

     return Gson().fromJson(json, DashboardData::class.java)
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
     HomeScreen()
}