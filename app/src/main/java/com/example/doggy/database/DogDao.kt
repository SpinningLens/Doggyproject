package com.example.doggy.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.doggy.network.DogImage


@Dao
interface DogDao {
    @Query("SELECT * FROM DogImages")
    fun getAll(): LiveData<List<DogImage>>

    @Query("SELECT * FROM DogImages ORDER BY id DESC LIMIT 1")
    fun getMostRecentlyAddDog () : DogImage

    @Query ("DELETE from DogImages where id = (select max (id)-1 from DogImages)")
    suspend fun deleteDog()


    @Insert
    suspend fun addDogImage (dogImageEntity: DogImage)
}