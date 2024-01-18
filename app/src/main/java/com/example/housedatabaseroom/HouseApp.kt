package com.example.housedatabaseroom

import android.app.Application

class HouseApp: Application() {
    lateinit var container: AppContainer


    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }

}