package com.rein.exploraplan.model

data class Budget(
    val id: String,
    val name: String,
    val status: String,
    val plan: String,
    val expense: Long,
    var date: Long
)
