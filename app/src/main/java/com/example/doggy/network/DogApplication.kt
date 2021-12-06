package com.example.doggy.network

import android.app.Application
import androidx.room.Room
import com.example.doggy.database.DogDatabase

class DogApplication:Application() {

    override fun onCreate(){
        super.onCreate()

        ApplicationManager.initialize(this)
    }
}
object ApplicationManager {
    private lateinit var application: Application

    // Initialize of room database
    val db by lazy{
        Room.databaseBuilder(
            this.application,
            DogDatabase::class.java,
             "app_database")
        .build()
    }

    fun initialize(application: Application){
    this.application = application
}
}