package exploracion.exploradores

open class Explorador(
    val nombre: String,
    energiaInicial: Int = 100,
    distanciaInicial: Double = 0.0
) {
    // Encapsulación con Setter personalizado para restringir el rango [0, 100]
    var energia: Int = energiaInicial
        set(valor) {
            field = when {
                valor > 100 -> 100
                valor < 0 -> 0
                else -> valor
            }
        }

    var distanciaRecorrida: Double = distanciaInicial
        protected set // Solo las subclases o la misma clase pueden modificar la distancia directamente

    // Propiedad calculada con getter personalizado
    val estadoEnergia: String
        get() = when {
            energia > 70 -> "ÓPTIMO"
            energia in 21..70 -> "MODERADO"
            energia in 1..20 -> "CRÍTICO"
            else -> "AGOTADO"
        }

    init {
        // Asignación directa que pasa por el setter personalizado
        this.energia = energiaInicial
    }

    open fun desplazarse(distancia: Double) {
        if (energia <= 0) {
            println("[$nombre] No se puede desplazar: Energía agotada.")
            return
        }
        val consumo = calcularConsumo(distancia)
        energia -= consumo
        distanciaRecorrida += distancia
        println("[$nombre] Se desplazó $distancia km. Energía restante: $energia% ($estadoEnergia).")
    }

    // Método privado encapsulado
    private fun calcularConsumo(distancia: Double): Int {
        return (distancia * 2).toInt() // Regla base: 2% de energía por km
    }

    fun mostrarInformacion() {
        println("--- Explorador: $nombre ---")
        println("Energía: $energia% ($estadoEnergia)")
        println("Distancia Recorrida: $distanciaRecorrida km")
    }
}