package com.example.housedatabaseroom.ui.screen

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.housedatabaseroom.HouseApp
import com.example.housedatabaseroom.data.House
import com.example.housedatabaseroom.repository.HouseRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


data class ShowUIScreen(   val houseList: List<House> = listOf())
class ShowScreenViewModel( private  val houseRepository: HouseRepository): ViewModel() {
var param = "Population"

val UiState : StateFlow<ShowUIScreen> = houseRepository.getHouseByArea().map{ShowUIScreen(it)}
    .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
        initialValue = ShowUIScreen()
    )

    suspend fun deleteHouse(house: House)= houseRepository.DeleteHouse(house)

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
        val Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as HouseApp)
                val repository = application.container.houseRepository
                ShowScreenViewModel(repository)
            }
        }
    }
}