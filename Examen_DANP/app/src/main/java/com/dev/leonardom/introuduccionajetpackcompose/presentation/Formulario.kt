package com.dev.leonardom.introuduccionajetpackcompose.presentation

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.leonardom.introuduccionajetpackcompose.R


@Composable
fun Formulario(
    nombre:String,
    funNombre: (String) -> Unit,
    tipo:String,
    funTipo: (String) -> Unit,
    fecha: String,
    funFecha: (String) -> Unit,
    distrito: String,
    funDistrito: (String) -> Unit,
    referencia: String,
    funReferencia: (String) -> Unit,
    isEditando: Boolean,
    funIsEditando: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    listaIncidente: MutableList<Incidente>,
    funResetCampos: () -> Unit
){
    //Imagen
    Image(
        painter = painterResource(R.drawable.form),
        contentDescription = "Descripcion de la imagen",

    )
    Spacer(modifier = Modifier.padding(vertical = 4.dp))

    //Titulo
    Text(
        text = "Registro de Incidentes",
        style = TextStyle(
            fontSize = 37.sp,
            textAlign = TextAlign.Center,
            shadow = Shadow(
                color = Color.Gray,
                offset = Offset(5.0f, 10.0f),
                blurRadius = 3f
            )
        )
    )
    Spacer(modifier = Modifier.padding(vertical = 15.dp))
    //Obtener Nombre
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funNombre(it) },
        label = { Text(text = "Ingrese el nombre del incidente") },
        enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 1.dp))

    //Obtener Tipo
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = tipo,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funTipo(it) },
        label = { Text(text = "Ingrese tipo de incidente: Rotura - Fisura - Atoro") },
    )
    Spacer(modifier = Modifier.padding(vertical = 1.dp))

    //Obtener Fecha
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = fecha,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funFecha(it) },
        label = { Text(text = "Fecha del incidente") },
        enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 1.dp))

    //Obtener distrito
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = distrito,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funDistrito(it) },
        label = { Text(text = "Ingrese distrito de la ubicación") },
    )
    Spacer(modifier = Modifier.padding(vertical = 1.dp))

    //Obtener referencia
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = referencia,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 2,
        onValueChange = { funReferencia(it) },
        label = { Text(text = "Ingrese Referencia de la ubicación") },
    )
    Spacer(modifier = Modifier.padding(vertical = 1.dp))

    //Botones
    Button(modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
        onClick = {
            if (isEditando) {
                editIncidente(nombre, tipo, fecha, distrito, referencia, listaIncidente)
                funTextButton("Agregar Asistente")
                funIsEditando()

            } else {
                addIncidente(nombre, tipo, fecha, distrito, referencia, listaIncidente)
            }
            funResetCampos()
        }
    ) {
        Text(
            color = Color.White,
            text = textButton
        )
    }
}