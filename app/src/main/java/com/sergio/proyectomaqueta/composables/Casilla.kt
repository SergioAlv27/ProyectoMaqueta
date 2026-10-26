package com.sergio.proyectomaqueta.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class EstadoCasilla { AGUA, FALLO, TOCADO, HUNDIDO, BARCO }

@Composable
fun Casilla(
    estado: EstadoCasilla = EstadoCasilla.AGUA,
    tamano: Dp = 28.dp
) {
    val color = when (estado) {
        EstadoCasilla.AGUA, EstadoCasilla.FALLO -> Color(0xFF4A90D9)
        EstadoCasilla.TOCADO -> Color(0xFFE24B4A)
        EstadoCasilla.HUNDIDO -> Color(0xFF791F1F)
        EstadoCasilla.BARCO -> Color(0xFF888780)
    }

    Box(
        modifier = Modifier
            .size(tamano)
            .clip(RoundedCornerShape(tamano / 8))
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        when (estado) {
            EstadoCasilla.FALLO -> Box(
                modifier = Modifier
                    .size(tamano / 4)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            EstadoCasilla.TOCADO, EstadoCasilla.HUNDIDO ->
                Text("✕", color = Color.White, fontSize = (tamano.value * 0.5f).sp)
            else -> {}
        }
    }
}