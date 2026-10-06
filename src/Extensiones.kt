package exploracion.utilidades

// Función de extensión sobre el tipo Double
fun Double.comoDistancia(): String {
    return String.format("%.2f km", this)
}

// Función de extensión sobre el tipo Int para formato de energía
fun Int.comoPorcentajeEnergia(): String {
    return "$this%"
}