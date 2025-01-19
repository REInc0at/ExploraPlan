package com.rein.exploraplan.model

import java.sql.Time

data class TouristSpot(
    val id: String,
    val username: String,
    val address: String,
    val priceRange: String,
    val openTime: Time,
    val closeTime: Time,
    val rate: Long
)
