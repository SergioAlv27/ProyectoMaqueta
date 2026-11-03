package com.sergio.proyectomaqueta.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.proyectomaqueta.R

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
fun Reloj(tiempo: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFE8E8E8))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(tiempo, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.Black)
    }
}

@Composable
fun Marcador(titulo: String, valor: String) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFE8E8E8))
            .padding(horizontal = 16.dp, vertical = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(titulo, fontSize = 12.sp, color = Color.DarkGray)
        Text(valor, fontSize = 20.sp, fontWeight = FontWeight.Medium, color = Color.Black)
    }
}

@Composable
fun Jugador(nombre: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Foto del jugador",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
        )
        Text(nombre, fontSize = 14.sp)
    }
}

@Composable
fun FilaBarco(nombre: String, longitud: Int, tocadas: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(nombre, fontSize = 12.sp, modifier = Modifier.width(88.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            for (i in 1..longitud) {
                val color = if (i <= tocadas) ColorTocado else ColorBarco
                Casilla(color, 12.dp)
            }
        }
    }
}

@Composable
fun PanelFlota() {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("Tu flota", fontSize = 13.sp, fontWeight = FontWeight.Medium)
        FilaBarco("Portaaviones", 5, 0)
        FilaBarco("Acorazado", 4, 1)
        FilaBarco("Crucero", 3, 0)
        FilaBarco("Submarino", 3, 0)
        FilaBarco("Destructor", 2, 0)
    }
}

@Composable
fun Pantalla(modifier: Modifier = Modifier) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = ColorFondo,
        contentColor = Color.White
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Hundir la flota", fontSize = 22.sp)
                Reloj("00:42")
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Jugador("Sergio")
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Color(0xFFE6F1FB))
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Text("Tu turno", fontSize = 14.sp, color = Color(0xFF0C447C))
                }
            }

            Tablero()


            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                PanelFlota()
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Marcador("Disparos", "8")
                    Marcador("Aciertos", "5")
                }
            }


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
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPreview() {
    Pantalla()
}