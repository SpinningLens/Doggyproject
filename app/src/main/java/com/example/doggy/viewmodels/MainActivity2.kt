package com.example.doggy.viewmodels

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doggy.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val actionBar = supportActionBar

        actionBar!!.title = "Main Activity 2"

        actionBar.setDisplayHomeAsUpEnabled(true)

    }

}