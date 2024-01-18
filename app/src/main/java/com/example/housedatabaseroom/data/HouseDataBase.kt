package com.example.housedatabaseroom.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

 abstract class HouseDataBase: RoomDatabase() {
  abstract fun houseDao(): HouseDao


  companion object
  @Volatile
  private var Instance : HouseDataBase? = null

  fun getDataBase( context: Context): HouseDataBase{
   return Instance ?: synchronized(this){
    Room.databaseBuilder(context, HouseDataBase::class.java,"house_database")
     .fallbackToDestructiveMigration()
     .build()
     .also { Instance = it  }}
  }
}