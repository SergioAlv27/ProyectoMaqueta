package com.sergio.proyectomaqueta.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Colores del juego (variables sueltas)
val ColorAgua = Color(0xFF4A90D9)
val ColorFallo = Color(0xFFBBD7F5)
val ColorTocado = Color(0xFFE24B4A)
val ColorHundido = Color(0xFF791F1F)

@Composable
fun Casilla(color: Color, tamano: Dp = 30.dp) {
    Box(
        modifier = Modifier
            .size(tamano)
            .clip(RoundedCornerShape(4.dp))
            .background(color)
    )
}