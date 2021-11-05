package com.example.doggy.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://dog.cee/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface DogImageApiService{

    //https://dog.ceo/api/breeds/image/random
    @GET("breeds/image/random")
    suspend fun getRandomPhoto() : dogImage
}
 object DogImageApi{
     val retrofitService: DogImageApiService by lazy {
         retrofit.create ((DogImageApiService::class.java))
     }
 }
