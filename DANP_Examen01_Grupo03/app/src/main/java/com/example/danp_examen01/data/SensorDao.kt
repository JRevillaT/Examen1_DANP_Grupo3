package com.example.danp_examen01.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SensorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSensor(sensor: SensorEntity)

    @Query("SELECT * FROM SensorEntity")
    suspend fun getSensores(): List<SensorEntity>
}