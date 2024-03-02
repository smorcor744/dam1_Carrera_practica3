import kotlin.math.roundToInt

class Camion(nombre: String,
             override var marca: String = "",
             override var modelo: String = "",
             capacidadCombustible: Float,
             combustibleActual: Float,
             kilometrosActuales: Float,
             esHibrido: Boolean,
             val peso: Float
) : Automovil(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales, esHibrido
) {
    companion object {
        const val KM_X_LITRO_CAMION = 16f
        const val PESOKM_X_LITRO = 0.2f
    }
   init {
       require(peso >= 1000 || peso <= 10000){"El peso no puede ser superior a 10000kg ni inferior a 1000kg."}
   }

    override fun calcularAutonomia(): Float {
        val pesoquitar = peso /1000
        return if (esHibrido) {
            (AHORRO_ELECTRICO * KM_X_LITRO_CAMION - (pesoquitar.roundToInt() * PESOKM_X_LITRO)).redondear(2)

        } else (KM_X_LITRO_CAMION - (pesoquitar.roundToInt() * PESOKM_X_LITRO)).redondear(2)

    }
}