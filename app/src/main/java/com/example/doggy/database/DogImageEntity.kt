package com.example.doggy.network


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity (tableName = "DogImages")
data class DogImage(
    @PrimaryKey(autoGenerate = true)
    @Transient
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @Json (name = "message")
     @ColumnInfo( name = "image_url")
    val message : String,


    @Json(name = "status")
    @ColumnInfo(name = "status")
    val statusResponse: String,

)