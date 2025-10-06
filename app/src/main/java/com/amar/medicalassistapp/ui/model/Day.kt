package com.amar.medicalassistapp.ui.model

import kotlinx.serialization.SerialName

data class Day(
     @SerialName("day") val day: String,
     @SerialName("date") val date: Int,
     @SerialName("isSelected") val isSelected: Boolean
)