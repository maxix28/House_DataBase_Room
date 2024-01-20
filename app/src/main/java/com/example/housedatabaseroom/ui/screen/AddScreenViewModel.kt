package com.example.housedatabaseroom.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.housedatabaseroom.HouseApp
import com.example.housedatabaseroom.data.House
import com.example.housedatabaseroom.repository.HouseRepository



data class HomeAddUIState(
    var Name: String="",
    var Area : String="",
    var Population :String="" ,
    var AwayFromCenter:String=""
)
class AddScreenViewModel( private val houseRepository: HouseRepository): ViewModel() {
    var UiState by mutableStateOf(HomeAddUIState())
    var EmptyName by mutableStateOf( UiState.Name.isNotEmpty())
    var EmptyArea by mutableStateOf( UiState.Area.isNotEmpty())
    var EmptyPopulation = UiState.Population.isNotEmpty()
    var EmptyAwayFromCenter = UiState.AwayFromCenter.isNotEmpty()

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
suspend fun addHouse(){
    houseRepository.AddHouse(UiState.toHouse())
}
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as HouseApp)
                val repository = application.container.houseRepository
                AddScreenViewModel(repository)
            }
        }



    }

}
fun HomeAddUIState.toHouse():House = House(Name= Name, Population =  Population.toInt(), Area = Area.toInt(), AwayFromCenter = AwayFromCenter.toInt())