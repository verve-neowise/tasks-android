package io.mbos.newsapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.mbos.newsapp.ui.theme.CompletedColors
import io.mbos.newsapp.ui.theme.WorkSans

@Composable
fun AppBar(title: String) {
    Row(modifier = Modifier.fillMaxWidth().background(CompletedColors.onPrimary).padding(15.dp)) {
        Text(
            modifier = Modifier,
            text = title,
            fontFamily = WorkSans,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp
        )
    }
}