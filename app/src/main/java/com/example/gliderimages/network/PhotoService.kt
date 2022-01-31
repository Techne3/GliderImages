package com.example.gliderimages.network

import com.example.gliderimages.network.models.PhotoModel
import retrofit2.Response
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
    suspend fun getPhotos(): Response<List<PhotoModel>>
}