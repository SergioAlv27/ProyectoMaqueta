package com.sergio.proyectomaqueta.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilaTablero() {
    Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        repeat(10) {
            Casilla()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilaTableroPreview() {
    FilaTablero()
}
@Composable
fun Tablero() {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        repeat(10) {
            FilaTablero()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TableroPreview() {
    Tablero()
}