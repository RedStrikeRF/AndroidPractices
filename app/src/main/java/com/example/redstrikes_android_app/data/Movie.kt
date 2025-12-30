package com.example.redstrikes_android_app.data

data class Movie(
    val id: Int,
    val title: String,
    val year: Int,
    val rating: Double,
    val genre: String,
    val director: String,
    val synopsis: String,
    val imageUrl: String = "",
    val duration: String
)