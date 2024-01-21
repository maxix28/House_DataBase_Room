package com.example.housedatabaseroom.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.housedatabaseroom.HouseApp
import com.example.housedatabaseroom.repository.HouseRepository
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(savedStateHandle: SavedStateHandle, private  val houseRepository: HouseRepository): ViewModel() {
var houseId : Int =  2

    var UiState by mutableStateOf(HomeAddUIState())

    init {
        viewModelScope.launch {
            UiState = houseRepository.getItem(2)
                .filterNotNull()
                .first()
                .toHouseState()
        }
    }

    fun setName( it : String){
        val current = UiState
        UiState = current.copy(Name = it)
    }
    fun setArea( it : String){
        val current = UiState
        UiState = current.copy(Area = it)
    }
    fun sertPopulation( it : String){
        val current = UiState
        UiState = current.copy(Population = it)
    }
    fun setAwayFromCenter( it : String){
        val current = UiState
        UiState = current.copy(AwayFromCenter = it)
    }



//    fun setArea( it : String){
//        val current = UiState
//        UiState = current.copy(Area = it)
//    }
//    fun sertPopulation( it : String){
//        val current = UiState
//        UiState = current.copy(Population = it)
//    }
//    fun setAwayFromCenter( it : String){
//        val current = UiState
//        UiState = current.copy(AwayFromCenter = it)
//    }

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