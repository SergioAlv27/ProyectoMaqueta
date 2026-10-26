package com.sergio.proyectomaqueta.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilaBarco(nombre: String, longitud: Int, tocadas: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(nombre, fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            repeat(longitud) { i ->
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(if (i < tocadas) Color(0xFFE24B4A) else Color(0xFFB4B2A9))
                )
            }
        }
    }
}

@Composable
fun Pantalla(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Cabecera
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Hundir la flota", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Text("00:42", fontSize = 14.sp)
        }

        // Turno
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Aguas enemigas", fontSize = 13.sp)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFE6F1FB))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text("Tu turno", fontSize = 12.sp, color = Color(0xFF0C447C))
            }
        }

        // Tablero enemigo
        Tablero(
            estados = mapOf(
                "C3" to EstadoCasilla.TOCADO, "C4" to EstadoCasilla.TOCADO,
                "F2" to EstadoCasilla.TOCADO, "B2" to EstadoCasilla.FALLO,
                "E7" to EstadoCasilla.FALLO, "H4" to EstadoCasilla.FALLO,
                "G6" to EstadoCasilla.HUNDIDO, "G7" to EstadoCasilla.HUNDIDO
            )
        )

        // Tu flota + estado de la flota enemiga
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Tu flota", fontSize = 13.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Tablero(
                    tamano = 13.dp,
                    conCoordenadas = false,
                    estados = mapOf(
                        "A1" to EstadoCasilla.BARCO, "B1" to EstadoCasilla.BARCO,
                        "C1" to EstadoCasilla.BARCO, "J3" to EstadoCasilla.TOCADO,
                        "B5" to EstadoCasilla.FALLO
                    )
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text("Flota enemiga", fontSize = 13.sp)
                FilaBarco("Portaaviones", 5, 0)
                FilaBarco("Acorazado", 4, 1)
                FilaBarco("Crucero", 3, 0)
                FilaBarco("Submarino", 3, 0)
                FilaBarco("Destructor", 2, 2)
            }
        }

        // Botones (no hacen nada, es una maqueta)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(onClick = {}, modifier = Modifier.weight(1f)) { Text("Rendirse") }
            Button(onClick = {}, modifier = Modifier.weight(1f)) { Text("Ajustes") }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPreview() {
    Pantalla()
}