package com.example.housedatabaseroom.repository

import com.example.housedatabaseroom.data.House
import kotlinx.coroutines.flow.Flow

interface HouseRepository {
    suspend fun AddHouse( house: House)
    fun DeleteHouse(house: House)
    fun getItemByParam( PARAM : String): Flow<List<House>>
}