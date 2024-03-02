class Quad(nombre: String,
           override var marca: String = "",
           override var modelo: String = "",
           capacidadCombustible: Float,
           combustibleActual: Float,
           kilometrosActuales: Float,
           cilindrada: Int
) :Motocicleta(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales, cilindrada
) {
    companion object{

    }
    override fun calcularAutonomia(): Float {
        return super.calcularAutonomia() / 2
    }
}