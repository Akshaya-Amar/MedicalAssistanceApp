package com.amar.medicalassistapp.ui.model

import kotlinx.serialization.SerialName

data class Dashboard(
     @SerialName("card") val card: Card,
     @SerialName("categories") val categories: List<Category>,
     @SerialName("upcomingSchedules") val upcomingSchedules: List<UpcomingSchedule>
)