package com.example.brightbeemd.model

data class Course(
    val id: Int,
    val title: String,
    val author: String,
    val description: String,
    val link: String,
    val category: String,
    val rating: Float
)
