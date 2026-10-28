package com.sergio.proyectomaqueta.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Leyenda(color: Color, texto: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Casilla(color, 14.dp)
        Text(texto, fontSize = 12.sp)
    }
}

@Composable
fun Pantalla(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
    ) {
        Text("Hundir la flota", fontSize = 24.sp)
        Text("Tu turno: dispara a las aguas enemigas", fontSize = 14.sp)

        Tablero()

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Leyenda(ColorAgua, "Agua")
            Leyenda(ColorFallo, "Fallo")
            Leyenda(ColorTocado, "Tocado")
            Leyenda(ColorHundido, "Hundido")
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {}) { Text("Rendirse") }
            Button(onClick = {}) { Text("Ajustes") }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPreview() {
    Pantalla()
}