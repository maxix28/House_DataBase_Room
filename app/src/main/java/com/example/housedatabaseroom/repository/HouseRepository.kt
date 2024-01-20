package com.example.housedatabaseroom.repository

import com.example.housedatabaseroom.data.House
import kotlinx.coroutines.flow.Flow

interface HouseRepository {
    suspend fun AddHouse( house: House)
    suspend fun DeleteHouse(house:House)
    fun getHouseByArea( ): Flow<List<House>>


    fun getItemByParam( PARAM : String): Flow<List<House>>
}