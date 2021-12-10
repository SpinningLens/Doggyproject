package com.example.doggy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.doggy.network.DogApplication

class DogViewModelFactory (
   var application: DogApplication):ViewModelProvider.Factory{

    override fun<T: ViewModel> create (modelClass: Class <T>): T{
        if (modelClass.isAssignableFrom((DogViewModel::class.java))){

            //@Suppress ("UNCHECKED CAST")
            return DogViewModel(application)as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}