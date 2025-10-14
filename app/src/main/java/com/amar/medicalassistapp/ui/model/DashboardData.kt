package com.amar.medicalassistapp.ui.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName

@Immutable
data class DashboardData(
     @SerialName("dashboard") val dashboard: Dashboard
)