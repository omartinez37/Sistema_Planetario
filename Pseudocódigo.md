# Exploración Planetaria - Simulador Kotlin

## Descripción del Proyecto
Este programa simula las operaciones de una misión científica de exploración planetaria. Modela vehículos exploradores (rovers terrestres y drones aéreos), zonas con diferentes riesgos, hallazgos científicos y un centro de control centralizado utilizando la programación orientada a objetos en Kotlin.

## Estructura del Proyecto
- `exploracion.modelo`: Contiene el `enum class TipoZona` y la `data class Descubrimiento`.
- `exploracion.exploradores`: Contiene la clase abstracta `Explorador`, sus subclases `RoverTerrestre` y `DronExplorador`, y la interfaz `Analizable`.
- `exploracion.control`: Contiene el singleton `CentroControl` (`object`).
- `exploracion.utilidades`: Contiene funciones de extensión (`Extensiones.kt`).
- `Main.kt`: Punto de entrada que coordina y ejecuta la simulación con sus pruebas.

## Reglas de Energía
Todos los exploradores manejan un nivel de energía acotado estrictamente entre **0% y 100%**. La propiedad `energia` implementa un setter personalizado utilizando `coerceIn(0, 100)` para impedir asignaciones fuera de este intervalo.

## Pseudocódigo / Lógica Principal
```text
INICIO
  Instanciar RoverTerrestre y DronExplorador
  Verificar incremento en Companion Object (totalExploradores)
  Probar Setter de energía asignando valores fuera de límites (<0 y >100)
  Desplazar exploradores -> Descontar batería y acumular distancia
  Para cada explorador en Lista<Analizable>:
      Ejecutar analizarZona(TipoZona)
  Crear Descubrimiento base (Data Class)
  Clonar Descubrimiento con copy() modificando la zona
  CentroControl realiza simulación de análisis aleatorio
  Ejecutar pruebas adicionales (movimiento sin batería y métodos abstractos)
  Mostrar resumen de misión desde CentroControl
FIN
