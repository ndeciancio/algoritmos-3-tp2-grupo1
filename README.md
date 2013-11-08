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

No subí diagrama de secuencia, pero les dejo la secuencia acá en texto:

0. Antes que nada, hay una clase abstracta Movimiento, de la que heredan MovimientoDerecha, MovimientoIzquierda, etc. (si ya se, no es bonito, pero esta idea mucho más lejos no la pude llevar).

1. Jugador recibe de algún lado (Controlador quizas) el mensaje mover(unMovimiento). Hay sobrecargados diferentes métodos mover para diferentes movimientos, por ejemplo mover(MovimientoDerecha), mover(MovimientoIzquierda), etc.

2. El jugador cuando recibe el mensaje mover, copia su posición actual en posiciónAnterior. Para evitar repetir código, se puede hacer:
mover(Movimiento unMovimiento){
	posicionAnterior.setx(posicion.x());
	posicionAnterior.sety(posicion.y());
	moverPrivado(unMovimiento); 
	// moverPrivado manejaría el tipo específico de movimiento.
}

3. El moverPrivado, o como se valla a llamar, modifica la posición. La posición a la que tiene acceso el jugador debería ser la de la esquina en la que está (osea, el jugador no tiene porque saber que tiene que aumentar la posición en 2 y no en 1). Luego de eso, moverPrivado envía el mensaje notificarMovimiento al GPS.

4. El GPS también tiene sobrecargados diferentes métodos notificarMovimiento (ya se, ya se, si se les ocurre algo mejor me avisan). notificarMovimiento toma la posición actual (la que recién fue modificada por jugador), y dependiendo del método que reaccionó, le manda el mensaje interactuarCon(jugador) a un evento diferente. Por ejemplo, si Movimiento es del tipo MovimientoDerecha, tiene que activar el evento en el x actual menos uno. Si Movimiento fuese del tipo MovimientoIzquierda, tiene que activar el evento en x actual mas uno.

Una cosa sobre el mapa. Yo diría que los eventos se guarden en una matriz. Si el mapa es conceptualmente de 20x20, la matriz sería de 40x40, con eventos entre medio de cada esquina. Por ejemplo, si se llama a notificarMovimiento con un MovimientoDerecha como parámetro, y el GPS ve que posicion.x y posicion.y devuelven 5 y 4 respectivamente, entonces se activa el evento en (x,y) = ((5*2)-1, (4*2)). De nuevo... ya se que no es lindo, pero es más feo que el Jugador tenga  que saber que tiene que aumentar la posición en 2, y que desde afuera todo el mundo tenga que dividir la posición por 2.

5. El interactuarCon(Jugador) puede hacer varias cosas: si es una bonificación o penalización, solo tiene que aumentar o disminuir los movimientos del jugador. Si es un obstáculo, envía el mensaje cruzar(this) obstáculo al jugador. El jugador delega el cruzar al vehículo, y el cruzar del vehículo aumenta los movimientos del jugador. Para el que quiera saber porqué el jugador tiene un vehiculo y no al revés como arreglamos... piensen como implementar un cambio de vehículo con el diseño en el que quedamos hoy en clase. Si se les ocurre me cuentan.

6. Si no se puede cruzar, el vehículo le envía el mensaje volverAtras al jugador, y el jugador solo tiene que modificar su posición sin subir ni bajar movimientos. También se enviaría vovlerAtras cuando notificarMovimiento recibe un movimiento inválido (por ejemplo, si el GPS ve que el movimiento que recibió se sale de los límites, directamente envía volverAtras
sin activar ningún evento).

7. Yo diría que en todos los caminos en los que no hay eventos como bonificaciones, o penalizaciones, o lo que sea, haya un evento MovimientoSimple que solo aumenta los movimientos del jugador y nada más. Así cuando el jugador no puede mover por algún obstáculo o algo, no se le cuentan movimientos.

8. En la posición final (la meta), habría un evento MetaAlcanzada que al interactuar con el jugador toma su nombre y su puntuación y los guarda, termina el juego, y otras cosas que tenga que hacer.

Resta pensar como inicializar vehículos con referencias al jugador. Yo diría un patrón Factory con un enumerado estilo Java. Para conseguir una moto, por ejemplo, sería: FabricaVehiculos.MOTOCICLETA.crearPara(jugador), o algo parecido.
FabricaVehiculos y Vehiculo estarían en el mismo paquete. El constructor de vehículo tendría visibilidad de paquete y solo se debería poder obtener vehículos a partir de la fábrica.

