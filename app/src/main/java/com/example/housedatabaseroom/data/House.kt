package com.example.housedatabaseroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.housedatabaseroom.ui.screen.HomeAddUIState

@Entity(tableName = "HouseBase")
data class House(
    @PrimaryKey(autoGenerate = true)
    val id : Int =0,
    val Name: String,
    val Area : Int ,
    val Population : Int ,
    val AwayFromCenter: Int
) {
    fun toHouseState(): HomeAddUIState = HomeAddUIState(Name = Name, Area =Area.toString(), Population = Population.toString(), AwayFromCenter = AwayFromCenter.toString())
}
