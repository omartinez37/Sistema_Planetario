package exploracion.exploradores

class DronExplorador(
    nombre: String,
    energiaInicial: Int = 100,
    val altitudMaxima: Int = 50
) : Explorador(nombre, energiaInicial) {

    override fun desplazarse(distancia: Double) {
        if (energia <= 0) {
            println("[$nombre - Dron] Batería agotada para volar.")
            return
        }
        val consumo = (distancia * 4).toInt() // El vuelo consume más energía
        energia -= consumo
        distanciaRecorrida += distancia
        println("[$nombre - Dron] Realizó vuelo de $distancia km a una altitud de $altitudMaxima m. Energía restante: $energia%.")
    }

    override fun ejecutarMisionEspecial() {
        println("[$nombre - Dron] Escaneando mapa altimétrico tridimensional desde el aire.")
    }
}