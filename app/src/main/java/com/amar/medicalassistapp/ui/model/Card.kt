package com.amar.medicalassistapp.ui.model

import kotlinx.serialization.SerialName

data class Card(
    @SerialName("days") val days: List<Day>,
    @SerialName("specialists") val specialists: List<Specialist>
)