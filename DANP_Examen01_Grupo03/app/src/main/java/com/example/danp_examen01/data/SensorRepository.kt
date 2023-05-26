package com.example.danp_examen01.data

//Esto es para acceder a la base de datos
class SensorRepository(
    private val sensorDao: SensorDao
) {
    suspend fun getSensores(): List<Sensor>{
        val entities = sensorDao.getSensores()
        return entities.map {
            Sensor(nombre = it.nombre)
        }
    }
    suspend fun insertSensor(sensor: Sensor){
        val entity = SensorEntity(nombre = sensor.nombre)
        sensorDao.insertSensor(entity)
    }
}