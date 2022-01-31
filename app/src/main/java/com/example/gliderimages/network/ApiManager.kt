package com.example.gliderimages.network

class ApiManager {

    private var photoService: PhotoService =
        RetrofitInstance.providesRetrofit().create(PhotoService::class.java)

    suspend fun getPhotos() = photoService.getPhotos()
}