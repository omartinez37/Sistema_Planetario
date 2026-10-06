import exploracion.control.CentroControl
import exploracion.exploradores.*
import exploracion.modelo.*
import exploracion.utilidades.*

fun main() {
    println("==================================================")
    println("   INICIANDO SIMULADOR DE MISIÓN PLANETARIA       ")
    println("==================================================\n")

    // 1. Creación de Objetos y demostración de Companion Object
    val roverAres = RoverTerrestre(nombre = "Ares-1", energiaInicial = 90, traccion4x4 = true)
    val dronIcaro = DronExplorador(nombre = "Ícaro-X", energiaInicial = 100, altitudMaxima = 80)

    println("\nExploradores registrados en la clase base: ${Explorador.totalExploradoresCreados}")

    // 2. Probar setter de energía (Valores fuera de rango)
    println("\n--- PRUEBA: Setter de Energía con valores fuera de límite ---")
    roverAres.energia = 150
    println("Asignado 150% -> Energía real: ${roverAres.energia.comoPorcentajeEnergia()}")
    roverAres.energia = -50
    println("Asignado -50% -> Energía real: ${roverAres.energia.comoPorcentajeEnergia()}")
    roverAres.energia = 85 // Restaurar valor operativo

    // 3. Desplazamientos y Funciones de Extensión
    println("\n--- PRUEBA: Desplazamientos y Consumo de Energía ---")
    val distRover = 12.5
    roverAres.desplazarse(distRover)
    println("Distancia formateada con extensión: ${roverAres.distanciaRecorrida.comoDistancia()}")

    val distDron = 5.0
    dronIcaro.desplazarse(distDron)

    // 4. Polimorfismo y uso de Interfaz Analizable
    println("\n--- PRUEBA: Polimorfismo e Interfaz Analizable ---")
    val exploradoresAnalizables: List<Analizable> = listOf(roverAres, dronIcaro)
    for (explorador in exploradoresAnalizables) {
        explorador.analizarZona(TipoZona.ROCOSA)
    }

    // 5. Data Class y función copy()
    println("\n--- PRUEBA: Data Class y copy() ---")
    val descubrimientoBase = Descubrimiento(
        tipo = "Agua congelada",
        descripcion = "Depósito hallado a 2 metros de profundidad",
        zona = TipoZona.SEGURA
    )
    println("Descubrimiento original: $descubrimientoBase")

    val descubrimientoCopia = descubrimientoBase.copy(
        descripcion = "Depósito masivo confirmado por dron",
        zona = TipoZona.PELIGROSA
    )
    println("Descubrimiento duplicado con copy(): $descubrimientoCopia")

    CentroControl.registrarDescubrimiento(descubrimientoBase)
    CentroControl.registrarDescubrimiento(descubrimientoCopia)

    // 6. Análisis Aleatorio de la Misión (Sugerencia del problema)
    println("\n--- PRUEBA: Análisis Aleatorio de Misión desde CentroControl ---")
    val (zonaAleatoria, hallazgoAleatorio) = CentroControl.simularAnalisisRandom()
    println("Zona analizada automáticamente: $zonaAleatoria (Riesgo: ${zonaAleatoria.nivelRiesgo})")
    if (hallazgoAleatorio != null) {
        CentroControl.registrarDescubrimiento(hallazgoAleatorio)
    } else {
        println("No se detectaron hallazgos en esta inspección.")
    }

    // 7. Pruebas Adicionales Diseñadas
    println("\n--- PRUEBAS ADICIONALES ---")
    // Prueba Adicional 1: Desplazamiento sin energía
    println("Prueba Adicional 1: Intentar mover explorador sin energía")
    dronIcaro.energia = 0
    dronIcaro.desplazarse(10.0)

    // Prueba Adicional 2: Ejecución de misiones especiales específicas de subclases
    println("\nPrueba Adicional 2: Métodos abstractos sobrescritos")
    roverAres.ejecutarMisionEspecial()
    dronIcaro.ejecutarMisionEspecial()

    // 8. Resumen final desde el Singleton
    CentroControl.generarResumenMision()
}