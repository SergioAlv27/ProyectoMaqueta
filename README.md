# ProyectoMaqueta · Hundir la flota

Maqueta de la pantalla de juego de **Hundir la flota** para Android, desarrollada como proyecto de clase de DAM2.

> Es un prototipo visual: **no tiene lógica de juego**. Los colores de las casillas, el reloj, los marcadores y los barcos son datos fijos de ejemplo para mostrar cómo se vería una partida. Los botones se ven, pero no hacen nada.


## Qué incluye la pantalla

- **Cabecera** con el título del juego y un reloj.
- **Jugador**: avatar redondo con su nombre y un indicador de turno ("Tu turno").
- **Tablero** de 10x10 casillas con coordenadas (letras A-J arriba y números 1-10 a la izquierda).
- **Panel "Tu flota"** con los 5 barcos (portaaviones, acorazado, crucero, submarino y destructor), marcando en rojo las casillas tocadas.
- **Marcadores** de disparos y aciertos.
- **Leyenda** de colores.
- **Botones** "Rendirse" y "Ajustes".
- **Fondo azul marino** con textos claros.

### Colores de las casillas

| Estado | Color |
|---|---|
| Agua | Azul |
| Fallo | Azul claro |
| Tocado | Rojo |
| Hundido | Rojo oscuro |
| Barco | Gris |

## Tecnologías

- Android Studio
- Kotlin
- Jetpack Compose (Material 3)

## Cómo ejecutarlo

1. Clona el repositorio:
   ```bash
   git clone https://github.com/SergioAlv27/ProyectoMaqueta
   ```
2. Abre la carpeta del proyecto en Android Studio.
3. Espera a que termine la sincronización de Gradle.
4. Ejecuta la app en un emulador o en un dispositivo físico.

## Estructura del código

```
app/src/main/
├── java/com/sergio/proyectomaqueta/
│   ├── MainActivity.kt          # Punto de entrada: muestra la pantalla
│   └── composables/
│       ├── Casilla.kt           # Casilla individual y colores del juego
│       ├── Tablero.kt           # Tablero 10x10 con coordenadas, hecho con bucles for
│       └── Pantalla.kt          # Pantalla completa y sus piezas (reloj, marcadores, flota...)
└── res/drawable/
    └── avatar.png               # Foto del jugador
```

### Cómo está construido

- **`Casilla`**: un `Box` cuadrado con esquinas redondeadas. Recibe el color y el tamaño como parámetros, así sirve para el tablero, la leyenda y los barcos.
- **`Etiqueta`**: un `Box` del mismo tamaño que una casilla con un texto centrado, para las letras y los números del tablero.
- **`Tablero`**: dos bucles `for` anidados dentro de una `Column` y una `Row` crean las 100 casillas. Con `if` se elige el color de cada una según su fila y columna.
- **`Reloj` y `Marcador`**: pequeñas cajas con fondo claro y texto, reutilizables con distintos datos.
- **`Jugador`**: una `Image` recortada en círculo junto a un `Text`.
- **`FilaBarco` y `PanelFlota`**: dibujan cada barco como una fila de casillas pequeñas, usando un `for` según su longitud.
- **`Pantalla`**: junta todo dentro de un `Surface` azul marino y una `Column` con `Arrangement.SpaceBetween`.

## Autor

- **Nombre:** Sergio Álvarez
- **Curso:** DAM2
- **Asignatura:** Programación multimedia y dispositivos móviles
