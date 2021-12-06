package com.example.doggy.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase
import com.example.doggy.network.ApplicationManager
import com.example.doggy.network.DogImage
import com.example.doggy.network.DogImageApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageRepository {
    private val serviceScope = CoroutineScope(Dispatchers.Default)

    init{
        serviceScope.launch (Dispatchers.IO){
            getRandomDogImage()
        }
    }
    suspend fun getRandomDogImage(){
        try{
            val dog = DogImageApi.retrofitService.getRandomPhoto()
            ApplicationManager.db.dogDao().insertAll(dog)

        }catch(e:Exception){
            Log.e("DogViewModel", "Error occurred: $ {e.mesage}")
        }
    }
    fun getDogs(): LiveData<List<DogImage>>{
        return ApplicationManager.db.dogDao().getAll()
    }
}



