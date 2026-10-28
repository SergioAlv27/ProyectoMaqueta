# ProyectoMaqueta · Hundir la flota

Maqueta de la pantalla de juego de **Hundir la flota** para Android, desarrollada como proyecto de clase de DAM2.

> Es un prototipo visual: **no tiene lógica de juego**. Los colores de las casillas son fijos y sirven de ejemplo de cómo se vería una partida. Los botones se ven, pero no hacen nada.

## Captura

![Pantalla de juego](Capturas/pantalla_maqueta.png)

## Qué incluye la pantalla

- Título del juego y mensaje de turno.
- Tablero de 10x10 casillas.
- Leyenda de colores.
- Botones "Rendirse" y "Ajustes".

### Colores de las casillas

| Estado | Color |
|---|---|
| Agua | Azul |
| Fallo | Azul claro |
| Tocado | Rojo |
| Hundido | Granate |

## Tecnologías

- Android Studio
- Kotlin
- Jetpack Compose (Material 3)

## Cómo ejecutarlo

1. Clona el repositorio:
   ```bash
   git clone https://github.com/TU_USUARIO/TU_REPOSITORIO.git
   ```
2. Abre la carpeta del proyecto en Android Studio.
3. Espera a que termine la sincronización de Gradle.
4. Ejecuta la app en un emulador o en un dispositivo físico.

## Estructura del código

```
app/src/main/java/com/sergio/proyectomaqueta/
├── MainActivity.kt          # Punto de entrada: muestra la pantalla
└── composables/
    ├── Casilla.kt           # Una casilla (color y tamaño) y los colores del juego
    ├── Tablero.kt           # Tablero 10x10 hecho con bucles for
    └── Pantalla.kt          # Pantalla completa: título, tablero, leyenda y botones
```

### Cómo está construido

- **`Casilla`**: un `Box` cuadrado con esquinas redondeadas. Recibe el color y el tamaño como parámetros.
- **`Tablero`**: dos bucles `for` anidados dentro de una `Column` y una `Row` crean las 100 casillas. Con `if` se elige el color de cada una según su fila y columna.
- **`Pantalla`**: junta todo en una `Column` centrada con `Text`, el tablero, una leyenda y dos `Button`.

## Autor

- **Nombre:** TU NOMBRE
- **Curso:** DAM2
- **Asignatura:** TU ASIGNATURA
