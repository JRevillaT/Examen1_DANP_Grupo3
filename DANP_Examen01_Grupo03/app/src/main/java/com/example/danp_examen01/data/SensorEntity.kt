package com.example.danp_examen01.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SensorEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nombre: String
) {
}