package com.example.danp_examen01


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
import com.example.danp_examen01.R
import com.example.danp_examen01.presentation.screens.addIncidente
import com.example.danp_examen01.presentation.screens.editIncidente


@Composable
fun Formulario(
    nombre:String,
    funNombre: (String) -> Unit,
    nivel:String,
    funNivel: (String) -> Unit,
    caudal: String,
    funCaudal: (String) -> Unit,
    estado: String,
    funEstado: (String) -> Unit,
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
        text = "Registro de Estados",
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

    //Obtener Nivel
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nivel,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funNivel(it) },
        label = { Text(text = "Ingrese el nivel del Caudal") },
    )
    Spacer(modifier = Modifier.padding(vertical = 1.dp))

    //Obtener Caudal
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = caudal,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funCaudal(it) },
        label = { Text(text = "Ingresar el volumen del Caudal") },
        enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 1.dp))

    //Obtener Estado
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = estado,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funEstado(it) },
        label = { Text(text = "Ingrese el estado: ") },
    )
    Spacer(modifier = Modifier.padding(vertical = 1.dp))

    //Botones
    Button(modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0.0f, 0.8f, 0.8f),),
        onClick = {
            if (isEditando) {
                editIncidente(nombre, nivel, caudal, estado, listaIncidente)
                funTextButton("Agregar un nuevo Estado")
                funIsEditando()

            } else {
                addIncidente(nombre, nivel, caudal, estado, listaIncidente)
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