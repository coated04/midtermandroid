package com.example.midtermandroid.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midtermandroid.data.AppDatabase
import com.example.midtermandroid.data.ComputerComponent
import com.example.midtermandroid.ui.screens.components.ItemCard

@Composable
fun DetailsScreen() {
    val context = LocalContext.current
    val db = remember { AppDatabase.getDatabase(context) }
    val dao = db.componentDao()

    var components by remember { mutableStateOf<List<ComputerComponent>>(emptyList()) }
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        val existingComponents = dao.getAll()
        if (existingComponents.isEmpty()) {
            dao.insert(ComputerComponent(name = "Apple's laptops (MacBook)"))
            dao.insert(ComputerComponent(name = "Gaming PCs"))
        }
        components = dao.getAll()
        isVisible = true
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(animationSpec = tween(500)) + slideInVertically(initialOffsetY = { it / 2 })
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp)
        ) {
            Text(
                text = "I like these kinds of computers:",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn {
                items(components) { item ->
                    ItemCard(item.name)
                }
            }

            Text(
                text = "I want to build a gaming PC, but it’s more reasonable to buy a MacBook for my studies.",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}
