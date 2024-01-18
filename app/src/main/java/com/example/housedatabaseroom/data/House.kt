package com.example.housedatabaseroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class House(
    @PrimaryKey(autoGenerate = true)
    var id : Int =0,
    var Area : Int ,
    var Population : Int ,
    var AwayFromCenter: Int
)
