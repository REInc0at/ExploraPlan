package com.rein.exploraplan.model

data class Expense(
    val id: String,
    val name: String,
    val value: String,
    var date: Long
)
