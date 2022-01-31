package com.example.gliderimages.repository

import android.util.Log
import com.example.gliderimages.TAG
import com.example.gliderimages.network.ApiManager
import com.example.gliderimages.network.models.PhotoModel
import java.lang.Exception


    class PhotoRepository(
private val apiManager: ApiManager
) {
    suspend fun getPhotos() : List<PhotoModel>? {
        return try {
            val response = apiManager.getPhotos()
            if (response.isSuccessful) {
                Log.v(TAG," ${response.isSuccessful}")
                Log.d(TAG," $response")
                response.body()
            } else {
                emptyList()
            }
        } catch (ex : Exception) {
            emptyList()
        }
    }
}