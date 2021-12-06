package com.example.doggy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.doggy.database.DogDao

class DogViewModelFactory (
    private val DogDao: DogDao
): ViewModelProvider.Factory{
    override fun<T: ViewModel> create (modelClass: Class <T>): T{
        if (modelClass.isAssignableFrom((DogViewModel::class.java))){

            @Suppress ("UNCHECKED CAST")
            return DogViewModel(DogDao)as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}