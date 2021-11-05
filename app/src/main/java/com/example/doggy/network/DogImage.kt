package com.example.doggy.network

import com.squareup.moshi.Json

data class dogImage (

    @Json (name = "message") val imageUrl : String?,
    @Json (name = "status") val statusResponse: String?
)