package com.example.housedatabaseroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface HouseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun AddHouse( house: House)

    @Delete
    fun DeleteHouse(house: House)

    @Query("SELECT * FROM House ORDER BY :PARAM Asc ")
    fun getItemByParam( PARAM : String): Flow<List<House>>

}