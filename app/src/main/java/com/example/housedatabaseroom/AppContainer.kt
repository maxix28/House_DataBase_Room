package com.example.housedatabaseroom

import android.content.Context
import com.example.housedatabaseroom.data.HouseDataBase
import com.example.housedatabaseroom.repository.HouseRepository
import com.example.housedatabaseroom.repository.OfflineHouseRepository

interface AppContainer {
    val houseRepository : HouseRepository
}

class DefaultAppContainer( val context: Context): AppContainer{
    override val houseRepository: HouseRepository by lazy {
        OfflineHouseRepository(HouseDataBase.getDataBase(context).houseDao())
    }
}
