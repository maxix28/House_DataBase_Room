package com.example.housedatabaseroom.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.housedatabaseroom.ui.screen.AddDestination
import com.example.housedatabaseroom.ui.screen.AddHouse
import com.example.housedatabaseroom.ui.screen.EditDestination
import com.example.housedatabaseroom.ui.screen.EditScreen
import com.example.housedatabaseroom.ui.screen.HomeDestination
import com.example.housedatabaseroom.ui.screen.mainScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HouseNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
NavHost(
    navController = navController,
    startDestination = HomeDestination.route,
    modifier = modifier
)
{
    composable(route = HomeDestination.route) {
        mainScreen(
         onEdit = {navController.navigate(EditDestination.route)},
            onAdd = {navController.navigate(AddDestination.route)}
        )
    }
    composable(route = AddDestination.route) {
        AddHouse()
    }
    composable(route = EditDestination.route) {
        EditScreen()
    }


}
}