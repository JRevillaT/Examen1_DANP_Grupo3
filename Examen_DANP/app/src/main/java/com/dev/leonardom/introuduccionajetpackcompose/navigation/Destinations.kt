package com.dev.leonardom.introuduccionajetpackcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Pantalla1: Destinations("pantalla1", "Login", Icons.Filled.Login)
    object Pantalla2: Destinations("pantalla2/?newText={newText}", "Registro", Icons.Filled.TableRows) {
        fun createRoute(newText: String) = "pantalla2/?newText=$newText"
    }
    object Pantalla3: Destinations("pantalla3", "Ver Registros", Icons.Filled.List)
}
