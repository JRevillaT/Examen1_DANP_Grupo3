package com.example.danp_examen01.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.danp_examen01.Formulario
import com.example.danp_examen01.Incidente

@Composable
fun Pantalla2(
    text: String
) {
    var listaIncidentes = remember{ mutableListOf<Incidente>() }
    Text(
        text = "Bienvenido "+text,
        modifier = Modifier.padding(12.dp),
        style = TextStyle(color = Color.Black, fontSize = 42.sp, fontWeight = FontWeight.Black)
    )
    Box(modifier = Modifier.fillMaxSize()){
        ScreenCRUD(listaIncidentes)
    }
}

@Composable
fun ScreenCRUD(listaIncidente: MutableList<Incidente>){
    var nombre by remember{ mutableStateOf("") }
    var nivel by remember{ mutableStateOf("") }
    var caudal by remember{ mutableStateOf("") }
    var estado by remember{ mutableStateOf("") }
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Incidente") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Formulario(
            nombre = nombre,
            funNombre ={nombre = it},
            nivel = nivel,
            funNivel = {nivel = it},
            caudal = caudal,
            funCaudal = {caudal = it},
            estado = estado,
            funEstado = {estado = it},
            isEditando = isEditando,
            funIsEditando = {isEditando = false},
            textButton = textButton,
            funTextButton = {textButton = it},
            listaIncidente = listaIncidente,
            funResetCampos = {
                nombre = ""
                nivel = ""
                caudal = ""
                estado = ""
            }
        )
    }
}

fun addIncidente(nombre:String, nivel:String, caudal:String, estado:String, listaIncidente: MutableList<Incidente>){
    listaIncidente.add(Incidente(nombre, nivel, caudal, estado))
}
fun editIncidente(nombre:String, nivel:String, caudal:String, estado:String, listaIncidente: MutableList<Incidente>){
    listaIncidente.forEach({incidente ->
        if(incidente.nombre == nombre){
            incidente.nivel = nivel
            incidente.caudal = caudal
            incidente.estado = estado
        }
    })
}