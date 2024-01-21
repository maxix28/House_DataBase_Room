package com.example.housedatabaseroom.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.housedatabaseroom.ui.navigation.NavigationDestination
import com.example.housedatabaseroom.ui.theme.EmptyRed
import kotlinx.coroutines.launch

object  EditDestination: NavigationDestination {
    override val route: String
        get() = "edit"
    const val houseIdArg = "id"
    val routeWithArgs = "$route/{$houseIdArg}"
}
@Composable
fun EditScreen(modifier: Modifier = Modifier, editViewModel : EditViewModel= viewModel(factory = EditViewModel.Factory)){
    val coroutineScope = rememberCoroutineScope()
    //val UIState = editViewModel.UiState.collectAsState()

    Column(modifier = modifier.padding(horizontal = 8.dp, vertical = 5.dp )) {
        OutlinedTextField(
            value = editViewModel.UiState.Name,
            onValueChange = {editViewModel.setName(it)
                            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Name") },
            colors = if (editViewModel.UiState.Name.isEmpty()) OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            )
            else OutlinedTextFieldDefaults.colors(
                focusedContainerColor = EmptyRed,
                unfocusedContainerColor = EmptyRed,
                disabledContainerColor = EmptyRed,
            ),

            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        OutlinedTextField(
            value = editViewModel.UiState.Area.toString(),
            onValueChange = {// addViewModel.setArea(it)
                            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            label = { Text("Area") },
            colors = if (editViewModel.UiState.Area.isEmpty()) OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            )
            else OutlinedTextFieldDefaults.colors(
                focusedContainerColor = EmptyRed,
                unfocusedContainerColor = EmptyRed,
                disabledContainerColor = EmptyRed,
            ),

            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        OutlinedTextField(
            value = editViewModel.UiState.Population,
            onValueChange = { //addViewModel.sertPopulation(it)
                 },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            label = { Text("Population") },
            colors = if (editViewModel.UiState.Population.isEmpty()) OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            )
            else OutlinedTextFieldDefaults.colors(
                focusedContainerColor = EmptyRed,
                unfocusedContainerColor = EmptyRed,
                disabledContainerColor = EmptyRed,
            ),

            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        OutlinedTextField(
            value = editViewModel.UiState.AwayFromCenter,
            onValueChange = {
                //addViewModel.setAwayFromCenter(it)
                            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            label = { Text("Away from center") },
            colors = if (editViewModel.UiState.AwayFromCenter.isEmpty()) OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            )
            else OutlinedTextFieldDefaults.colors(
                focusedContainerColor = EmptyRed,
                unfocusedContainerColor = EmptyRed,
                disabledContainerColor = EmptyRed,
            ),

            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        Spacer(modifier = modifier.height(15.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                  //  addViewModel.addHouse()
                }
            },
            modifier = modifier.fillMaxWidth(),
            enabled = !(
                    editViewModel.UiState.AwayFromCenter.isEmpty()||
                            editViewModel.UiState.Area.isEmpty()||
                            editViewModel.UiState.Name.isEmpty()||
                            editViewModel.UiState.Population.isEmpty()
                    )
        ) {
            Text("Save Changes")
        }
    }
}