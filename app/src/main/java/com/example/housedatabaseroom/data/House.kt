package com.example.housedatabaseroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HouseBase")
data class House(
    @PrimaryKey(autoGenerate = true)
    val id : Int =0,
    val Name: String,
    val Area : Int ,
    val Population : Int ,
    val AwayFromCenter: Int
)
