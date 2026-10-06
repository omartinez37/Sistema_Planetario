package exploracion.exploradores

import exploracion.modelo.TipoZona

class RoverTerrestre(
    nombre: String,
    energiaInicial: Int = 100,
    val traccion4x4: Boolean = true
) : Explorador(nombre, energiaInicial), Analizable {

    override fun desplazarse(distancia: Double) {
        if (energia <= 0) return
        val consumo = (distancia * 3).toInt()
        energia -= consumo
        distanciaRecorrida += distancia
        println("[$nombre - Rover] Rodó $distancia km. Energía: $energia%.")
    }

    override fun ejecutarMisionEspecial() {
        println("[$nombre - Rover] Perforando estrato rocoso.")
    }

    override fun analizarZona(zona: TipoZona) {
        println("[$nombre - Rover] Analizando muestras de suelo en zona $zona...")
    }
}