package com.example.doggy.viewmodels

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doggy.R
import com.example.doggy.network.DogApplication
import com.example.doggy.network.DogImage
import com.example.doggy.repository.ImageRepository
import org.jetbrains.anko.doAsync
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var model: DogViewModel
    private lateinit var imageButton: Button
    private var Dog: String = ""
    private lateinit var repository: ImageRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = ImageRepository()

          recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
          imageButton = findViewById<Button>(R.id.imageButton)


        val modelFactory = DogViewModelFactory(application as DogApplication);

        model = ViewModelProvider(this,modelFactory).get(DogViewModel::class.java)

        val linearLayoutManger = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        model.allDogs.observe(this, Observer { dogs ->
            recyclerView.adapter = RecyclerViewAdapter(dogs)

        })

        findViewById<Button>(R.id.imageButton).setOnClickListener {
            doAsync{
                model.insert(DogImage(null, UUID.randomUUID().toString()))
            }
        }


    }
}










