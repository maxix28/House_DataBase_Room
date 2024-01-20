package com.example.housedatabaseroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow


//@Dao
// interface HouseDao {
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun AddHouse( house: House)
//
//
//
//    @Query("SELECT * FROM House ORDER BY :PARAM Asc ")
//    fun getItemByParam( PARAM : String): Flow<List<House>>
//
//}



@Dao
interface HouseDao{

    @Insert
    suspend fun AddHouse(house: House)
@Delete
suspend fun DeleteHouse(house:House)


    @Query("select * from HouseBase order by area  ASC")
    fun getHouseByArea( ): Flow<List<House>>

    @Query("select * from HouseBase order by :PARAM  ASC")
    fun getItemByParam( PARAM : String): Flow<List<House>>


}