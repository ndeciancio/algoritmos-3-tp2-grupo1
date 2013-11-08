Algoritmos y Programación III
Trabajo Práctico 2, Grupo 1
======================================

--------------------------------------
Integrantes:

Adrián Barreal - 95137
Horacio Martinez - 94926
Santiago Monsech Prada - 92968
Nicolas Deciancio - 92150
--------------------------------------

NOTAS:
Hola gente, soy Adrián. Ahí tengo un diseño que (aparentemente) resuelve el problema. No es el más bonito, pero no se me ocurría otra forma de resolver el problema usando solo las clases en las que quedamos hoy. Si ustedes tienen algo mejor, lo charlamos mañana.

<EDIT>
Despues de una charla en Skype con Horacio, surgió un diseño más simple (aunque tiene un par de cosas que no me convencen del todo). Ahí subí el diagrama. Probablemente les guste más <.< aunque a mi no me convence que el auto sepa que tiene que mover de a dos; queda atado a la implementación del mapa, cosa que el diseño anterior trata de evitar. Igualmente lo charlamos mañana (hoy bah).
</EDIT>

<EDIT>
Al final... usemos mejor el diseño simple y listo. Cualquier cosa lo arreglamos después.
</EDIT>

No subí diagrama de secuencia, pero les dejo la secuencia acá en texto:

El jugador recibe algún mensaje moverDerecha(), moverIzquierda(), etc. Eso hace cambiar en 2 su posición en x o y. Luego le pide al mapa el evento entre esos puntos y manda el interactuarCon. No es necesario verificar si es un movimiento válido; cuando el jugador pide el evento al mapa en una posición fuera de rango, el mapa devolvería un evento que al interactuar con el jugador le envía el mensaje volverAtras() y nada más.

El interactuarCon(Jugador) puede hacer varias cosas: si es una bonificación o penalización, solo tiene que aumentar o disminuir los movimientos del jugador. Si es un obstáculo, envía el mensaje cruzar(this) obstáculo al jugador. El jugador delega el cruzar al vehículo, y el cruzar del vehículo aumenta los movimientos del jugador. Para el que quiera saber porqué el jugador tiene un vehiculo y no al revés como arreglamos... piensen como implementar un cambio de vehículo con el diseño en el que quedamos hoy en clase. Si se les ocurre me cuentan.

Si no se puede cruzar, el vehículo le envía el mensaje volverAtras al jugador, y el jugador solo tiene que modificar su posición sin subir ni bajar movimientos. También se enviaría vovlerAtras cuando notificarMovimiento recibe una posición inválida.

Yo diría que en todos los caminos en los que no hay eventos como bonificaciones, o penalizaciones, o lo que sea, haya un evento MovimientoSimple que solo aumenta los movimientos del jugador y nada más. Así cuando el jugador no puede mover por algún obstáculo o algo, no se le cuentan movimientos.

En la posición final (la meta), habría un evento MetaAlcanzada que al interactuar con el jugador toma su nombre y su puntuación y los guarda, termina el juego, y otras cosas que tenga que hacer.

Resta pensar como inicializar vehículos con referencias al jugador. Yo diría un patrón Factory con un enumerado estilo Java. Para conseguir una moto, por ejemplo, sería: FabricaVehiculos.MOTOCICLETA.crearPara(jugador), o algo parecido.
FabricaVehiculos y Vehiculo estarían en el mismo paquete. El constructor de vehículo tendría visibilidad de paquete y solo se debería poder obtener vehículos a partir de la fábrica.

