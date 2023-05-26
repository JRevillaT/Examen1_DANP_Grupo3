package com.example.danp_examen01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.danp_examen01.data.MainViewModel
import com.example.danp_examen01.data.Sensor
import com.example.danp_examen01.data.SensorDatabase
import com.example.danp_examen01.data.SensorRepository
import com.example.danp_examen01.navigation.NavigationHost
import com.example.danp_examen01.presentation.components.BottomNavigationBar
import com.example.danp_examen01.ui.theme.DANP_Examen01Theme
import com.example.danp_examen01.navigation.Destinations.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(this, SensorDatabase::class.java,"sensor_db").build()
        val dao = db.dao
        val repository = SensorRepository(dao)
        val viewModel = MainViewModel(repository)
        setContent {
            MainScreen(viewModel)
        }
    }
}


@Composable
fun MainScreen(viewModel: MainViewModel) {
    val navController = rememberNavController()

    val navigationItems = listOf(
        Pantalla1,
        Pantalla2,
        Pantalla3
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController, items = navigationItems) },
    ){
        NavigationHost(navController, viewModel)
    }
}