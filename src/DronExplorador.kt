package exploracion.exploradores

import exploracion.modelo.TipoZona

class DronExplorador(
    nombre: String,
    energiaInicial: Int = 100,
    val altitudMaxima: Int = 50
) : Explorador(nombre, energiaInicial), Analizable {

    override fun desplazarse(distancia: Double) {
        if (energia <= 0) return
        val consumo = (distancia * 4).toInt()
        energia -= consumo
        distanciaRecorrida += distancia
        println("[$nombre - Dron] Vuelo de $distancia km. Energía: $energia%.")
    }

    override fun ejecutarMisionEspecial() {
        println("[$nombre - Dron] Capturando imágenes multiespectrales.")
    }

    override fun analizarZona(zona: TipoZona) {
        println("[$nombre - Dron] Escaneando térmicamente superficie desde el aire en zona $zona...")
    }
}