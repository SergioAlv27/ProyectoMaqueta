package com.sergio.proyectomaqueta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sergio.proyectomaqueta.composables.Pantalla
import com.sergio.proyectomaqueta.ui.theme.ProyectoMaquetaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoMaquetaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Pantalla(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}