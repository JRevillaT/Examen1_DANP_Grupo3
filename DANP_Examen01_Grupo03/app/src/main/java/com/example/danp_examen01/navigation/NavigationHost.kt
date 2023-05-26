package com.example.danp_examen01.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.danp_examen01.data.MainViewModel
import com.example.danp_examen01.data.SensorDatabase
import com.example.danp_examen01.data.SensorRepository
import com.example.danp_examen01.navigation.Destinations.*
import com.example.danp_examen01.presentation.screens.Pantalla1
import com.example.danp_examen01.presentation.screens.Pantalla2
import com.example.danp_examen01.presentation.screens.Pantalla3

@Composable
fun NavigationHost(
    navController: NavHostController,
    viewModel: MainViewModel
) {

    NavHost(navController = navController, startDestination = Pantalla1.route) {
        composable(Pantalla1.route) {
            Pantalla1(
                navegarPantalla2 = { newText ->
                    navController.navigate(Pantalla2.createRoute(newText))
                }
            )
        }

        composable(
            Pantalla2.route,
            arguments = listOf(navArgument("newText"){ defaultValue = "" })
        ) { navBackStackEntry ->
            var newText = navBackStackEntry.arguments?.getString("newText")
            requireNotNull(newText)
            Pantalla2(newText)
        }

        composable(Pantalla3.route) {
            Pantalla3(viewModel)
        }
    }
}