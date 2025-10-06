package com.amar.medicalassistapp.ui.model

import kotlinx.serialization.SerialName

data class Specialist(
     @SerialName("id") val id: Int,
     @SerialName("name") val name: String,
     @SerialName("speciality") val speciality: String,
     @SerialName("rating") val rating: Double,
     @SerialName("profileImage") val profileImage: String
)