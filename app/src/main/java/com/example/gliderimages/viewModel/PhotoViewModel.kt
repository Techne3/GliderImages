package com.example.gliderimages.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.gliderimages.TAG
import com.example.gliderimages.network.models.PhotoModel
import com.example.gliderimages.repository.PhotoRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class PhotoViewModel (private val photoRepository: PhotoRepository) : ViewModel() {

    private  var _photos : MutableLiveData<List<PhotoModel>? > = MutableLiveData()
    val photos: LiveData<List<PhotoModel>?> = _photos

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            val response = photoRepository.getPhotos()
            Log.d(TAG, "RESPONSE $response")
            _photos.postValue(response)
        }
    }



    class Factory(
        private val photoRepository: PhotoRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PhotoViewModel::class.java)) {
                return PhotoViewModel(photoRepository) as T
            } else {
                throw RuntimeException("Could not create instance of UserViewModel")
            }
        }
    }
}