package com.example.danp_examen01.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.danp_examen01.data.MainViewModel
import com.example.danp_examen01.navigation.Destinations

@Composable
fun Pantalla3(viewModel: MainViewModel) {
    val state = viewModel.state
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(value = state.nombre, onValueChange = {viewModel.onNameChange(it)})
        Button(onClick = {viewModel.saveSensor()}) {
            Text(text = "Guardar")
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(state.sensores){
                //muestra el name de los sensores
                Text(text = it.nombre)
            }
        }
    }
}