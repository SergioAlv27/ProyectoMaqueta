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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Etiqueta(texto: String, tamano: Dp) {
    Box(
        modifier = Modifier.size(tamano),
        contentAlignment = Alignment.Center
    ) {
        Text(text = texto, fontSize = 12.sp)
    }
}

@Composable
fun Tablero(
    tamano: Dp = 28.dp,
    conCoordenadas: Boolean = true,
    estados: Map<String, EstadoCasilla> = emptyMap()
) {
    val letras = "ABCDEFGHIJ"

    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        if (conCoordenadas) {
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                Etiqueta("", tamano)
                letras.forEach { Etiqueta(it.toString(), tamano) }
            }
        }
        for (fila in 1..10) {
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                if (conCoordenadas) Etiqueta(fila.toString(), tamano)
                letras.forEach { letra ->
                    Casilla(
                        estado = estados["$letra$fila"] ?: EstadoCasilla.AGUA,
                        tamano = tamano
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TableroEnemigoPreview() {
    Tablero(
        estados = mapOf(
            "C3" to EstadoCasilla.TOCADO,
            "C4" to EstadoCasilla.TOCADO,
            "F2" to EstadoCasilla.TOCADO,
            "B2" to EstadoCasilla.FALLO,
            "E7" to EstadoCasilla.FALLO,
            "G6" to EstadoCasilla.HUNDIDO,
            "G7" to EstadoCasilla.HUNDIDO
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TableroPropioPreview() {
    Tablero(
        tamano = 15.dp,
        conCoordenadas = false,
        estados = mapOf(
            "A1" to EstadoCasilla.BARCO,
            "B1" to EstadoCasilla.BARCO,
            "C1" to EstadoCasilla.BARCO,
            "J3" to EstadoCasilla.TOCADO,
            "B5" to EstadoCasilla.FALLO
        )
    )
}

