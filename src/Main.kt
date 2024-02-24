
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Extiende la clase [Float] para permitir el redondeo del número a un número específico de posiciones decimales.
 *
 * @param posiciones El número de posiciones decimales a las que se redondeará el valor.
 * @return Un [Float] redondeado al número de posiciones decimales especificadas.
 */
fun Float.redondear(posiciones: Int): Float {
    val factor = 10.0.pow(posiciones.toDouble()).toFloat()
    return (this * factor).roundToInt() / factor
}

/**
 * Extiende la clase String para capitalizar las palabras de cualquier cadena de caracteres.
 * También elimina la secuencia de espacios al principio y final de la misma y delimita las palabras de la cadena por un
 * solo espacio.
 *
 * return Un [String] transformado con sus palabras capitalizadas y un solo espacio entre ellas.
 */
fun String.capitalizar(): String {
    // Elimina los espacios al principio y final de la cadena y reemplaza cualquier secuencia de espacios por uno solo.
    // Las palabras resultantes se asignan a una lista.
    val listaPalabras = this.trim().replace("\\s+".toRegex(), " ").split(" ")
    // Retorna la misma cadena de caracteres con las palabras capitalizadas y separadas por un solo espacio.
    return listaPalabras.joinToString(" ") { palabra -> palabra.lowercase().replaceFirstChar { it.uppercase() } }
}

/**
 * Punto de entrada del programa. Crea una lista de vehículos y una carrera, e inicia la carrera mostrando
 * los resultados al finalizar.
 */
fun main() {

    val vehiculos = listOf(
        Automovil("aurora", "Seat", "Panda", 50f, 50f * 0.1f, 0f, true),
        Automovil("Boreal m8", "BMW", "M8", 80f, 80f * 0.1f, 0f, false),
        Motocicleta("Céfiro", "Derbi", "Motoreta", 15f, 15f * 0.1f, 0f, 500),
        Automovil("Dinamo", "Cintroen", "Sor", 70f, 70f * 0.1f, 0f, true),
        Automovil("eclipse negro", "Renault", "Espacio", 60f, 60f * 0.1f, 0f, false),
        Motocicleta("Fénix", "Honda", "Vital", 20f, 20f * 0.1f, 0f, 250)
    )

    val carrera = Carrera("Gran Carrera de Filigranas", 1000f, vehiculos)

    println("\n*** ${carrera.nombreCarrera} ***\n")
    carrera.iniciarCarrera()

    val resultados = carrera.obtenerResultados()

    println("* Clasificación:\n")
    resultados.forEach { println("${it.posicion} -> ${it.vehiculo.nombre} (${it.vehiculo.kilometrosActuales} kms)") }

    println("\n" + resultados.joinToString("\n") { it.toString() })

    println("\n* Historial Detallado:\n")
    resultados.forEach { println("${it.posicion} -> ${it.vehiculo.nombre}\n${it.historialAcciones.joinToString("\n")}\n") }
}

