package com.example.danp_examen01.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Pantalla1: Destinations("pantalla1", "", Icons.Filled.Home)
    object Pantalla2: Destinations("pantalla2/?newText={newText}", "", Icons.Filled.Add) {
        fun createRoute(newText: String) = "pantalla2/?newText=$newText"
    }
    object Pantalla3: Destinations("pantalla3", "", Icons.Filled.List)
}
