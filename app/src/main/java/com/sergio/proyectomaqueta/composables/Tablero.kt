package com.sergio.proyectomaqueta.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Tablero() {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        for (fila in 1..10) {
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                for (columna in 1..10) {

                    // Elegimos el color según la posición
                    val color = if (fila == 3 && columna == 3) ColorTocado
                    else if (fila == 3 && columna == 4) ColorTocado
                    else if (fila == 2 && columna == 6) ColorTocado
                    else if (fila == 6 && columna == 7) ColorHundido
                    else if (fila == 7 && columna == 7) ColorHundido
                    else if (fila == 2 && columna == 2) ColorFallo
                    else if (fila == 5 && columna == 5) ColorFallo
                    else if (fila == 8 && columna == 3) ColorFallo
                    else ColorAgua

                    Casilla(color)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TableroPreview() {
    Tablero()
}