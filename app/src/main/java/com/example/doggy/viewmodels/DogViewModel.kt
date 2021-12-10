package com.example.doggy.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.doggy.database.DogDatabase
import com.example.doggy.network.DogApplication
import com.example.doggy.network.DogImage
import com.example.doggy.repository.ImageRepository

class DogViewModel (var application: DogApplication): ViewModel() {
    val repository: ImageRepository = ImageRepository()
    internal val DogImage: LiveData<List<DogImage>> = repository.getDogs()

    private val db: DogDatabase = DogDatabase.getInstance(application)
    internal val allDogs: LiveData<List<DogImage>> = db.dogDao().getAll()

    fun insert(dogImage: DogImage) {
        db.dogDao().getAll()
    }
}









