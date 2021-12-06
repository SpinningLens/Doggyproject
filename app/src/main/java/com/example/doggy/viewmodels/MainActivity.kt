package com.example.doggy.viewmodels

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.doggy.R
import com.example.doggy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: DogViewModel by viewModels{
        DogViewModelFactory((application as Application).database.DogDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        //getRandomDogPhoto()
    }
      changePhotoButton.setOnclickListener{
        val current ImgUrl =
        viewModel.DogDao.value?.variablenThatFile
        viewModel.getNewPhoto()

        val newDogImade = currentImgUrl?.let { itl ->
            DogImageEntity(imageUrl = it1)
        }
        if (newDogImage != null) {
            viewModel.addDog(newDogImage)
        }

     private fun getRandomDogPhoto() {
        //val randomPhotoButton = binding.imageDogButton
        //viewModel.dogImage.observe(
            ////this,
            //{
                //val imgUri =
                    //it.imageUrl!!.toUri().buildUpon().scheme("https").build()
                //binding.doggyphoto.load(imgUri)

            //},
        //)
         randomPhotoButton.setOnClickListener {
            viewModel.getNewPhoto()
             val intent = Intent( this, MainActivity2:: class.java)
             startActivity(intent)

        }

    }
         changePhotoButton.setOnclickListener{
                 val current ImgUrl =
             viewModel.DogDao.value?.variablenThatFile
             viewModel.getNewPhoto()

         val newDogImade = currentImgUrl?.let { itl ->
            DogImageEntity(imageUrl = it1)
        }
        if (newDogImage != null) {
            viewModel.addDog(newDogImage)
        }
    }




