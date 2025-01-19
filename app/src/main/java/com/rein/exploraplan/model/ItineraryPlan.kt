package com.rein.exploraplan.model

data class ItineraryPlan(
    val id: String,
    val name: String,
    val status: String,
    val destination: String,
    val budget: Long,
    var startDate: Long ,
    var endDate: Long ,
    var adults : Int ,
    var childs : Int
)
