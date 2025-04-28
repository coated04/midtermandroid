package com.example.midtermandroid.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ComponentDao {
    @Query("SELECT * FROM components")
    suspend fun getAll(): List<ComputerComponent>

    @Insert
    suspend fun insert(component: ComputerComponent)
}
