package com.example.doggy.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    private val _dogImage = MutableLiveData<DogImage>()
    val dogImage: LiveData<DogImage> = _dogImage

    init {
        getNewPhoto()
    }

    fun getNewPhoto() {
        viewModelScope.launch {
            _dogImage.value = DogImageApi.retrofitService.getRandomPhoto()
        }
    }

}