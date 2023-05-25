package com.dev.leonardom.introuduccionajetpackcompose.presentation

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
import com.dev.leonardom.introuduccionajetpackcompose.presentation.Incidente

@Composable
fun Pantalla2(
    text: String
) {
    var listaIncidentes = remember{ mutableListOf<Incidente>() }
    Box(modifier = Modifier.fillMaxSize()){
        ScreenCRUD(listaIncidentes)
    }
}

@Composable
fun ScreenCRUD(listaIncidente: MutableList<Incidente>){
    var nombre by remember{ mutableStateOf("") }
    var tipo by remember{ mutableStateOf("") }
    var fecha by remember{ mutableStateOf("") }
    var distrito by remember{ mutableStateOf("") }
    var referencia by remember{ mutableStateOf("") }
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Incidente") }
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(vertical = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Formulario(
            nombre = nombre,
            funNombre ={nombre = it},
            tipo = tipo,
            funTipo = {tipo = it},
            fecha = fecha,
            funFecha = {fecha = it},
            distrito = distrito,
            funDistrito = {distrito = it},
            referencia= referencia,
            funReferencia = {referencia = it},
            isEditando = isEditando,
            funIsEditando = {isEditando = false},
            textButton = textButton,
            funTextButton = {textButton = it},
            listaIncidente = listaIncidente,
            funResetCampos = {
                nombre = ""
                tipo = ""
                fecha = ""
                distrito = ""
                referencia = ""
            }
        )
    }
}

fun addIncidente(nombre:String, tipo:String, fecha:String, distrito:String, referencia:String, listaIncidente: MutableList<Incidente>){
    listaIncidente.add(Incidente(nombre, tipo, fecha, distrito, referencia))
}
fun editIncidente(nombre:String, tipo:String, fecha:String, distrito:String, referencia:String, listaIncidente: MutableList<Incidente>){
    listaIncidente.forEach({incidente ->
        if(incidente.nombre == nombre){
            incidente.tipo = tipo
            incidente.fecha = fecha
            incidente.distrito = distrito
            incidente.referencia = referencia
        }
    })
}