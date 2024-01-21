package com.example.housedatabaseroom.repository

import com.example.housedatabaseroom.data.House
import com.example.housedatabaseroom.data.HouseDao
import kotlinx.coroutines.flow.Flow

class OfflineHouseRepository( private val houseDao: HouseDao): HouseRepository {
    override suspend fun AddHouse(house: House) = houseDao.AddHouse(house)
    override suspend fun DeleteHouse(house: House) =houseDao.DeleteHouse(house)
    override suspend fun UpdateHouse(house: House) = houseDao.UpdateHouse(house)
    override fun getItem(id: Int): Flow<House> = houseDao.getItem(id)

    override fun getHouseByArea(): Flow<List<House>> = houseDao.getHouseByArea()
    override fun getItemByParam(PARAM: String): Flow<List<House>> =houseDao.getItemByParam(PARAM)
}