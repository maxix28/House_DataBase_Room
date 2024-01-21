package com.example.housedatabaseroom.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.housedatabaseroom.data.House
import com.example.housedatabaseroom.ui.navigation.NavigationDestination
import kotlinx.coroutines.launch

object  HomeDestination: NavigationDestination{
    override val route: String
        get() = "show"

}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun mainScreen( showScreenViewModel: ShowScreenViewModel= viewModel(factory = ShowScreenViewModel.Factory),
                onEdit : (Int)->Unit,modifier: Modifier= Modifier,onAdd:()->Unit ){
    val ShowUIState = showScreenViewModel.UiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick =  onAdd ) {
                Icon(Icons.Filled.AddCircle, contentDescription = "Favorite")
            }
        }){innerPadding->
        ShowHouse(ShowUIState.value.houseList, OnDelete ={
            coroutineScope.launch{
                showScreenViewModel.deleteHouse(it)
            }
        },
            onEdit = onEdit, modifier = modifier.padding(innerPadding).fillMaxSize())

    }



}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShowHouse(HouseList: List<House>, modifier: Modifier = Modifier, OnDelete:(House)-> Unit,  onEdit: (Int)->Unit){

LazyColumn(modifier = modifier){
items(HouseList){house->


        ShowOneHouse(house, OnDelete= {OnDelete(house)}, onEdit = {onEdit(it)})
    }

}

}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ShowOneHouse(house: House,modifier: Modifier = Modifier, OnDelete : (House)-> Unit, onEdit: (Int)->Unit ){
val coroutineScope = rememberCoroutineScope()
    val expand = rememberSaveable { mutableStateOf(false) }


    Card(
        modifier = modifier
            .padding(6.dp)
            .combinedClickable(
                onClick = {


                },
                onLongClick = {
                    expand.value = !expand.value
                },
            )
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),


        ){
        Column(modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)){
            Row(modifier = modifier.fillMaxWidth()){

                Text(text = house.Name, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = modifier.weight(1f))
                Text("Total area = " )
                Text(text = house.Area.toString(),style = MaterialTheme.typography.titleMedium)

            }
            Spacer(modifier = modifier.height(5.dp))
            Row(modifier = modifier.fillMaxWidth()){
                Text("Population in house = " )
                Text(text = house.Population.toString(), style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = modifier.weight(1f))
                Text("Away from center = " )

                Text(text = house.AwayFromCenter.toString(),style = MaterialTheme.typography.titleSmall)

            }

            if(expand.value){
                Row {
                    Spacer(modifier = modifier.weight(0.5f))

                    Button(onClick = { onEdit(house.id) }) {
                        Text("Edit")
                    }
                    Spacer(modifier = modifier.weight(1f))

                    Button(onClick = {
                        coroutineScope.launch {
                            OnDelete(house)


                    } }) {
                        Text("Delete")
                    }
                    Spacer(modifier = modifier.weight(0.5f))

                }
            }


        }
    }

}


@Preview(showBackground = true)
@Composable
fun HousePreview(){
//Column {
//
//
//            ShowOneHouse(House(1, "Lvivian", 123,234,23))
//            ShowOneHouse(House(1, "Zhovkva", 98,24,12))
//            ShowOneHouse(House(1, "RAva", 523,634,45))
//            ShowOneHouse(House(1, "Lvivian", 123,234,23))
//            ShowOneHouse(House(1, "Zhovkva", 98,24,12))
//            ShowOneHouse(House(1, "RAva", 523,634,45))
//            ShowOneHouse(House(1, "Lvivian", 123,234,23))
//            ShowOneHouse(House(1, "Zhovkva", 98,24,12))
//            ShowOneHouse(House(1, "RAva", 523,634,45))
//
//
//    }

}