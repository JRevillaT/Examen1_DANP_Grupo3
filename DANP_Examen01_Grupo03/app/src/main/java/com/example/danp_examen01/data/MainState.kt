package com.example.danp_examen01.data

data class MainState(
    val nombre: String = "",
    val sensores: List<Sensor> = emptyList()
) {}

//data class MainState(
//    val nombre: String = "",
//    val nivel = "",
//    val caudal = "",
//    val estado = "",
//)