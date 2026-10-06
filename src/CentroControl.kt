package exploracion.control

import exploracion.modelo.Descubrimiento
import exploracion.modelo.TipoZona
import kotlin.random.Random

object CentroControl {
    private val descubrimientos = mutableListOf<Descubrimiento>()
    private val eventosBitacora = mutableListOf<String>()

    fun registrarEvento(evento: String) {
        eventosBitacora.add(evento)
        println("[CENTRO DE CONTROL] $evento")
    }

    fun registrarDescubrimiento(descubrimiento: Descubrimiento) {
        descubrimientos.add(descubrimiento)
        println("[CENTRO DE CONTROL - HALLAZGO] Registrado: ${descubrimiento.tipo} en zona ${descubrimiento.zona}")
    }

    // Análisis aleatorio simulado
    fun simularAnalisisRandom(): Pair<TipoZona, Descubrimiento?> {
        val zonas = TipoZona.values()
        val zonaElegida = zonas[Random.nextInt(zonas.size)]

        val hallazgosPosibles = listOf(
            "Agua congelada",
            "Formación mineral",
            "Cráter",
            "Posible material orgánico"
        )

        val hayDescubrimiento = Random.nextBoolean()
        val descubrimiento = if (hayDescubrimiento) {
            Descubrimiento(
                tipo = hallazgosPosibles[Random.nextInt(hallazgosPosibles.size)],
                descripcion = "Muestra obtenida mediante exploración automatizada.",
                zona = zonaElegida
            )
        } else null

        return Pair(zonaElegida, descubrimiento)
    }

    fun generarResumenMision() {
        println("\n==========================================")
        println("      RESUMEN GENERAL DE LA MISIÓN        ")
        println("==========================================")
        println("Eventos registrados: ${eventosBitacora.size}")
        println("Descubrimientos totales: ${descubrimientos.size}")
        descubrimientos.forEachIndexed { index, desc ->
            println(" ${index + 1}. [${desc.zona}] ${desc.tipo}: ${desc.descripcion}")
        }
        println("==========================================\n")
    }
}