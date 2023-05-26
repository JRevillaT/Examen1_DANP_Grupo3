package com.example.danp_examen01.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Pantalla1: Destinations("pantalla1", "", Icons.Filled.Home)
    object Pantalla2: Destinations("pantalla2/?newText={newText}", "", Icons.Filled.Settings) {
        fun createRoute(newText: String) = "pantalla2/?newText=$newText"
    }
    object Pantalla3: Destinations("pantalla3", "", Icons.Filled.Favorite)
}
