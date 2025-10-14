package com.amar.medicalassistapp.ui.model

import kotlinx.serialization.SerialName

data class CardData(
    @SerialName("days") val days: List<Day>,
    @SerialName("specialists") val specialists: List<Specialist>
)