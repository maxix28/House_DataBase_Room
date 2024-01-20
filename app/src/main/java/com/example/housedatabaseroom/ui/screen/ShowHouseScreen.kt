package com.example.housedatabaseroom.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.housedatabaseroom.data.House


@Composable
fun ShowHouse(HouseList : List<House>,modifier: Modifier = Modifier){

LazyColumn(modifier = modifier){
items(HouseList){house->
    ShowOneHouse(house)
}
}

}


@Composable
fun ShowOneHouse(house: House,modifier: Modifier = Modifier){

    Card(modifier = modifier.padding(6.dp)){
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
    ShowHouse(listOf(House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23), House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),
        House(1, "Lvivian", 123,234,23),


    ))

}