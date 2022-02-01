package com.example.gliderimages.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoModel(
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)