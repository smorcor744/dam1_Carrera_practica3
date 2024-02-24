
## Práctica Carrera 3

Analiza y modifica el código de este repositorio para realizar los siguientes puntos:

### PARTE 1

#### 1. Pedir el número de participantes y por cada uno solicitar su nombre... El programa debe mostrar de forma aleatoria los datos del vehículo que le ha tocado a cada participante:

***Por ejemplo:***

   ```kotlin
   Introduce el número de participantes: 6

      * Nombre del vehículo 1 -> flash

      Te ha tocado un Automóvil(nombre=Flash, marca=Toyota, modelo=CHR, capacidad=53L, combustible=35,73L, eléctrico=SI)

      * Nombre del vehículo 2 -> torrente dos

      Te ha tocado una Motocicleta(nombre=Torrente Dos, marca=Derbi, modelo=Variant, capacidad=16L, combustible=9,44L, cc=125)
   ...
   ```


***Premisas:***

   - Para generar aleatoriamente la información de marca y modelo debéis tener un juego de posibles datos.

   - La capacidad debe ser un número Float pero sin decimales... Automóvil de 30 a 60L y el de la Motocicleta de 15 a 30L.

   - Para las motocicletas solo existirán las cilindradas 125, 250, 400, 500, 750, 900 y 1000.

   - El combustible debe ser un número con dos valores decimales entre el 20% y 100% de su capacidad.

   - Los datos específicos del vehículo deben generarse desde otro constructor que debéis crear en Automovil y Motocicleta.
     También debe solicitarse desde las clases el nombre del vehículo... los requisitos son que no se repita el nombre de ningún vehículo y que el nombre no este vacío o relleno con espacios.
     Debéis controlar que se produzca una excepción. 

