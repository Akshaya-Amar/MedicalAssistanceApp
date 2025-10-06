package com.amar.medicalassistapp.ui.model

import kotlinx.serialization.SerialName

data class Category(
     @SerialName("id") val id: Int,
     @SerialName("title") val title: String,
     @SerialName("icon") val icon: String
)