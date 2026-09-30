package exploracion.exploradores

abstract class Explorador(
    val nombre: String,
    energiaInicial: Int = 100,
    distanciaInicial: Double = 0.0
) {
    var energia: Int = energiaInicial
        set(valor) {
            field = valor.coerceIn(0, 100)
        }

    var distanciaRecorrida: Double = distanciaInicial
        protected set

    val estadoEnergia: String
        get() = when {
            energia > 70 -> "ÓPTIMO"
            energia in 21..70 -> "MODERADO"
            energia in 1..20 -> "CRÍTICO"
            else -> "AGOTADO"
        }

    init {
        this.energia = energiaInicial
    }

    open fun desplazarse(distancia: Double) {
        if (energia <= 0) {
            println("[$nombre] Sin energía para desplazarse.")
            return
        }
        val consumo = (distancia * 2).toInt()
        energia -= consumo
        distanciaRecorrida += distancia
        println("[$nombre] Avanzó $distancia km. Energía: $energia%.")
    }

    abstract fun ejecutarMisionEspecial()
}