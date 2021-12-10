package com.example.doggy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.doggy.network.DogImage

@Database(entities = [DogImage::class], version = 1, exportSchema = false)
abstract class DogDatabase :RoomDatabase() {
    abstract fun dogDao(): DogDao

    companion object {
        @Volatile
        private var INSTANCE: DogDatabase? = null

        fun getInstance(context: Context): DogDatabase {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,//.applicationContext,
                        DogDatabase::class.java,
                        "dog_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance

                }
                return INSTANCE as DogDatabase

            }


        }

    }




