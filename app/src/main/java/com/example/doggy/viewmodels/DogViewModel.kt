package com.example.doggy.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doggy.database.DogDao
import com.example.doggy.network.DogImage
import com.example.doggy.network.DogImageApi
import kotlinx.coroutines.launch

class DogViewModel
  : ViewModel() {
    private val _dogImage = MutableLiveData<DogImage>()
    val dogImage: LiveData<DogImage> = _dogImage

    //private val_status = DogImage ("", "success").status
    //val status = _status

    init {
        getNewPhoto()
    }

    fun getNewPhoto() {
        viewModelScope.launch {
            _dogImage.value = DogImageApi.retrofitService.getRandomPhoto()
        }

        fun addDog(DogImageEntity: DogImage) {
            viewModelScope.launch {
                DogDao.addDogImage(DogImageEntity)
            }
        }

        fun getAllDogs(): MutableLiveData<List<DogImage>> {
            return DogDao.getAllDogImages().asLiveData()


        }

    }


  }
