package exploracion.exploradores

import exploracion.modelo.TipoZona

interface Analizable {
    fun analizarZona(zona: TipoZona)
}