package io.mbos.newsapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        AppBar(title = "Tasks")
        TasksScreen()
    }
}