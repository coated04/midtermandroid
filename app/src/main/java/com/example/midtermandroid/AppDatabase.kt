package com.example.midtermandroid.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ComputerComponent::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun componentDao(): ComponentDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "components_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
