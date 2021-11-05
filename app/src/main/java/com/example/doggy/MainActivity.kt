package com.example.doggy

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import coil.load
import com.example.doggy.databinding.ActivityMainBinding
import com.example.doggy.network.DogViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRandomDogPhoto()
    }

     private fun getRandomDogPhoto() {
        val randomPhotoButton = binding.imageDogButton
        viewModel.dogImage.observe(
            this,
            {
                val imgUri =
                    it.imageUrl!!.toUri().buildUpon().scheme("https").build()
                binding.doggyphoto.load(imgUri)

            },
        )
        randomPhotoButton.setOnClickListener {
            viewModel.getNewPhoto()
        }

    }

}


