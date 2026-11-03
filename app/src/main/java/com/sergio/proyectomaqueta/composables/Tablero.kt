package com.sergio.proyectomaqueta.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Etiqueta(texto: String) {
    Box(
        modifier = Modifier.size(TamanoCasilla),
        contentAlignment = Alignment.Center
    ) {
        Text(texto, fontSize = 12.sp)
    }
}

@Composable
fun Tablero() {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {

        // Fila de arriba: un hueco vacío y las letras A-J
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            Etiqueta("")
            for (letra in "ABCDEFGHIJ") {
                Etiqueta(letra.toString())
            }
        }

        // Las 10 filas: primero el número y luego las 10 casillas
        for (fila in 1..10) {
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                Etiqueta(fila.toString())

                for (columna in 1..10) {

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