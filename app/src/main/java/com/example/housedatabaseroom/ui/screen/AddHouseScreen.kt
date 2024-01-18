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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.housedatabaseroom.ui.theme.EmptyRed

@Composable
fun AddHouse(modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(horizontal = 8.dp, vertical = 5.dp )) {
        OutlinedTextField(
            value = "",
            onValueChange = { },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Name") },
            colors = if (true) OutlinedTextFieldDefaults.colors(
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
            value = "",
            onValueChange = { },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            label = { Text("Area") },
            colors = if (true) OutlinedTextFieldDefaults.colors(
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
            value = "",
            onValueChange = { },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            label = { Text("Population") },
            colors = if (true) OutlinedTextFieldDefaults.colors(
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
            value = "",
            onValueChange = { },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            label = {Text("Away from center")},
            colors = if (true) OutlinedTextFieldDefaults.colors(
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
            onClick = { /*TODO*/ },
            modifier = modifier.fillMaxWidth(),
            enabled = true
        ) {
            Text("Save House")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showPreview(){
    AddHouse()
}