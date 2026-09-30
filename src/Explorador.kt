package exploracion.exploradores

open class Explorador(
    val nombre: String,
    energiaInicial: Int = 100, // Parámetro predeterminado
    distanciaInicial: Double = 0.0
) {
    var energia: Int = energiaInicial
    var distanciaRecorrida: Double = distanciaInicial

    init {
        println("Inicializando explorador: $nombre con $energia% de energía.")
    }
}