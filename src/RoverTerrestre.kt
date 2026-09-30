package exploracion.exploradores

class RoverTerrestre(
    nombre: String,
    energiaInicial: Int = 100,
    val traccion4x4: Boolean = true
) : Explorador(nombre, energiaInicial) {

    override fun desplazarse(distancia: Double) {
        if (energia <= 0) {
            println("[$nombre - Rover] Sin energía para rodar.")
            return
        }
        val factorTraccion = if (traccion4x4) 1.5 else 1.0
        val consumo = (distancia * 3 * factorTraccion).toInt()
        energia -= consumo
        distanciaRecorrida += distancia
        println("[$nombre - Rover] Rodó sobre superficie $distancia km. Consumo: $consumo%. Energía restante: $energia%.")
    }

    override fun ejecutarMisionEspecial() {
        println("[$nombre - Rover] Desplegando taladro para perforación de suelo.")
    }
}