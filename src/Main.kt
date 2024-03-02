
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


fun String.capitalizar(): String {
    return this.split(" ").joinToString(" ") { it.replaceFirstChar { it.uppercase() } }
}


/**
 * Punto de entrada del programa. Crea una lista de vehículos y una carrera, e inicia la carrera mostrando
 * los resultados al finalizar.
 */
fun main() {
    var numParticipantes = 0
    val vehiculos = mutableListOf<Vehiculo>()
    while (numParticipantes <= 0) {
        print("Introduce el número de participantes: ")
        numParticipantes = readln().toInt() ?: 0



        for (i in 1..numParticipantes) {
            var nombreVehiculo: String
            do {
                print("* Nombre del vehículo $i -> ")
                nombreVehiculo = readln().lowercase()
            } while (nombreVehiculo.isBlank())

            val vehiculo = participanteAleatorio(nombreVehiculo)
            println(
                "\nTe ha tocado un ${vehiculo::class.simpleName}(nombre=${(vehiculo.nombre).capitalizar()}, " +
                        "marca=${vehiculo.marca}, modelo=${vehiculo.modelo}, " +
                        "capacidad=${vehiculo.capacidadCombustible}L, " +
                        "combustible=${vehiculo.combustibleActual}L, " +
                        "${if (vehiculo is Automovil) if (vehiculo.esHibrido) "eléctrico=SI" else "eléctrico=NO" else if (vehiculo is Motocicleta) ", cc=${vehiculo.cilindrada}" else ""})\n"
            )

            vehiculos.add(vehiculo)
        }
    }

    val carrera = Carrera("Gran Carrera de Filigranas", 1000f, vehiculos)

    println("\n*** ${carrera.nombreCarrera} ***\n")
    carrera.iniciarCarrera()

    val resultados = carrera.obtenerResultados()

    println("* Clasificación:\n")
    resultados.forEach { println("${it.posicion} -> ${it.vehiculo.nombre} (${it.vehiculo.kilometrosActuales} kms)") }

    println("\n" + resultados.joinToString("\n") { it.toString() })

    println("\n* Historial Detallado:\n")
    resultados.forEach {
        println("${it.posicion} -> ${it.vehiculo.nombre}\n${it.historialAcciones.joinToString("\n")}\n")
    }
}







fun participanteAleatorio(nombre:String):Vehiculo{

    val vehiculo = (3..4).random()
    val papaOhijo = (1..2).random()

    if (papaOhijo == 1){
        when(vehiculo){
            3 ->return informacionAleatoria(vehiculo,papaOhijo,nombre)
            4 ->return informacionAleatoria(vehiculo,papaOhijo,nombre)
        }
    } else {
        when(vehiculo){
            3 ->return informacionAleatoria(vehiculo,papaOhijo,nombre)
            4 ->return informacionAleatoria(vehiculo,papaOhijo,nombre)
        }
    }
    return informacionAleatoria(vehiculo,papaOhijo,nombre)
}


fun informacionAleatoria(vehiculo:Int, num: Int,nombre:String): Vehiculo{
    if (vehiculo == 3){
        val coche:Vehiculo = Automovil(
            marca = marcaAleatoria(),
            modelo = modeloAleatoria(),
            capacidadCombustible = capacidadCombustibleAleatoria(vehiculo,num),
            combustibleActual = combustibleAleatorio(capacidadCombustibleAleatoria(vehiculo,num)),
            esHibrido = electricoAleatoria(),
            kilometrosActuales = 0f,
            nombre = nombre)
        return coche

    }else {
        val moto:Vehiculo = Motocicleta(
            marca = marcaMotoAleatoria(),
            modelo = modeloMotoAleatoria(),
            capacidadCombustible = capacidadCombustibleAleatoria(vehiculo,num),
            combustibleActual = combustibleAleatorio(capacidadCombustibleAleatoria(vehiculo,num)),
            cilindrada = cilindradaAleatoria(),
            kilometrosActuales = 0f,
            nombre = nombre)
        return moto
    }
}

fun marcaAleatoria(): String {
    val marcas = listOf("toyota","citroen","audi", "porche", "mitsubishi", "honda", "bmw", "seat", "renaul")
    return marcas.random()
}


fun modeloAleatoria(): String {
    val modelos = listOf("Sedán", "Hatchback", "SUV", "Deportivo", "Convertible", "Coupé", "Familiar")
    return modelos.random()
}


fun marcaMotoAleatoria(): String {
    val marcas = listOf("Honda", "Yamaha", "Suzuki", "Kawasaki", "Ducati", "BMW", "KTM", "Harley-Davidson")
    return marcas.random()
}

fun modeloMotoAleatoria(): String {
    val modelos = listOf("Deportiva", "Naked", "Touring", "Custom", "Off-road", "Trail", "Enduro")
    return modelos.random()
}

fun electricoAleatoria(): Boolean{
    val num = (1..2).random()
    if (num == 1) return false else return true
}

fun capacidadCombustibleAleatoria(vehiculo: Int, num:Int): Float {
    val capacidad: Float

    if (num == 1){
        capacidad = when (vehiculo) {
            3 -> (30..60).random().toFloat()
            4 -> (15..30).random().toFloat()
            else -> 0f
        }
    } else {
        capacidad = when (vehiculo) {
            3 -> (90..150).random().toFloat()
            4 -> (20..40).random().toFloat()
            else -> 0f
        }
    }
    return capacidad
}




fun cilindradaAleatoria(): Int {
    val cilindradas = listOf(125, 250, 400, 500, 750, 900 , 1000)
    return cilindradas.random()
}


fun combustibleAleatorio(capacidad: Float): Float {
    val porcentaje = (2000..10000).random()
    val combustible = capacidad * (porcentaje /10000)
    return combustible.redondear(2)
}