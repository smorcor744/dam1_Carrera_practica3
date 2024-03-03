class Quad(nombre: String,
           override var marca: String = "",
           override var modelo: String = "",
           capacidadCombustible: Float,
           combustibleActual: Float,
           kilometrosActuales: Float,
           cilindrada: Int,
            val tipo:TiposQuad = TiposQuad.VEHICULOS_ESPECIALES
) :Motocicleta(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales, cilindrada
) {
    override fun calcularAutonomia(): Float {
        return super.calcularAutonomia() / 2
    }
}