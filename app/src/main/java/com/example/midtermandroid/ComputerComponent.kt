package com.example.midtermandroid.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "components")
data class ComputerComponent(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)
