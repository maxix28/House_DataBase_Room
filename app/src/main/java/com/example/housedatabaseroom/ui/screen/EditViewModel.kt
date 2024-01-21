package com.example.housedatabaseroom.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.housedatabaseroom.HouseApp
import com.example.housedatabaseroom.repository.HouseRepository

class EditViewModel(savedStateHandle: SavedStateHandle, private  val houseRepository: HouseRepository): ViewModel() {

    var UiState by mutableStateOf(HomeAddUIState())
        private set
private val houseId : Int = 1
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
        val Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as HouseApp)
                val repository = application.container.houseRepository
                EditViewModel(this.createSavedStateHandle(),repository)
            }
        }
    }
}