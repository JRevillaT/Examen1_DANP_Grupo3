package com.example.danp_examen01.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val sensorRepository: SensorRepository
): ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                sensores = sensorRepository.getSensores()
            )
        }
    }

    fun onNameChange(nombre: String){
        state = state.copy(
            nombre = nombre
        )
    }
    fun saveSensor(){
        val sensor = Sensor(
            nombre = state.nombre
        )
        viewModelScope.launch {
            sensorRepository.insertSensor(sensor)
        }
    }
}