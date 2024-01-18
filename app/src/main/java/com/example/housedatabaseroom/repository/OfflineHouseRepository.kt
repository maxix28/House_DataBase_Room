package com.example.housedatabaseroom.repository

import com.example.housedatabaseroom.data.House
import com.example.housedatabaseroom.data.HouseDao
import kotlinx.coroutines.flow.Flow

class OfflineHouseRepository( private val houseDao: HouseDao): HouseRepository {
    override suspend fun AddHouse(house: House) = houseDao.AddHouse(house)
    override fun DeleteHouse(house: House) = houseDao.DeleteHouse(house)
    override fun getItemByParam(PARAM: String): Flow<List<House>> =houseDao.getItemByParam(PARAM)
}