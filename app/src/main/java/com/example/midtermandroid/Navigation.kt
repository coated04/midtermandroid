package com.example.midtermandroid.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.midtermandroid.ui.screens.DetailsScreen
import com.example.midtermandroid.ui.screens.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("details") { DetailsScreen() }
    }
}
