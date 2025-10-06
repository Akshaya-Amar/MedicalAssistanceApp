package com.amar.medicalassistapp.ui.model

import kotlinx.serialization.SerialName

data class UpcomingSchedule(
     @SerialName("id") val id: Int,
     @SerialName("doctorName") val doctorName: String,
     @SerialName("speciality") val speciality: String,
     @SerialName("date") val date: String,
     @SerialName("time") val time: String,
     @SerialName("profileImage") val profileImage: String
)