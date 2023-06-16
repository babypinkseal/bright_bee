package com.example.brightbee.data

data class SignInResponse(
    val token: String,
    val userId: String,
    val email: String
)
