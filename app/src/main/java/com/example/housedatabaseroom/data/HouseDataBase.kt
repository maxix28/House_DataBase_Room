package com.example.housedatabaseroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = arrayOf(House::class), version = 1)
 abstract class HouseDataBase: RoomDatabase(){
  abstract fun houseDao(): HouseDao

  companion object{
  @Volatile
  private var Instance : HouseDataBase? = null

  fun getDataBase( context: Context): HouseDataBase {
   return Instance ?: synchronized(this) {
    Room.databaseBuilder(context, HouseDataBase::class.java, "app_database")

     .fallbackToDestructiveMigration()
     .build()
     .also { Instance = it }
   }

  }

  }

}