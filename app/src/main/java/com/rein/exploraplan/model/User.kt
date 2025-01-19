package com.rein.exploraplan.model

data class User(
    val id: String,
    val username: String,
    val email: String,
    val password: String,
    val phone: String,
    val bday: String
)
