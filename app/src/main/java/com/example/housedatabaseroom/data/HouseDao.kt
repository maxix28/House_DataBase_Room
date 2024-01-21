package com.example.housedatabaseroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow



@Dao
interface HouseDao{

    @Insert
    suspend fun AddHouse(house: House)
    @Update
    suspend fun UpdateHouse(house: House)
     @Delete
     suspend fun DeleteHouse(house:House)

    @Query("SELECT * from HouseBase WHERE id = :id")
    fun getItem(id: Int): Flow<House>
    @Query("select * from HouseBase order by area  ASC")
    fun getHouseByArea( ): Flow<List<House>>

    @Query("select * from HouseBase order by :PARAM  ASC")
    fun getItemByParam( PARAM : String): Flow<List<House>>


}