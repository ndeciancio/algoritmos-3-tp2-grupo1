Algoritmos y Programaci�n III
Trabajo Pr�ctico 2, Grupo 1
======================================

--------------------------------------
Integrantes:

Adri�n Barreal - 95137
Horacio Martinez - 94926
Santiago Monsech Prada - 92968
Nicolas Deciancio - 92150
--------------------------------------

NOTAS:
Hola gente, soy Adri�n. Ah� tengo un dise�o que (aparentemente) resuelve el problema. No es el m�s bonito, pero no se me ocurr�a otra forma de resolver el problema usando solo las clases en las que quedamos hoy. Si ustedes tienen algo mejor, lo charlamos ma�ana.

No sub� diagrama de secuencia, pero les dejo la secuencia ac� en texto:

0. Antes que nada, hay una clase abstracta Movimiento, de la que heredan MovimientoDerecha, MovimientoIzquierda, etc. (si ya se, no es bonito, pero esta idea mucho m�s lejos no la pude llevar).

1. Jugador recibe de alg�n lado (Controlador quizas) el mensaje mover(unMovimiento). Hay sobrecargados diferentes m�todos mover para diferentes movimientos, por ejemplo mover(MovimientoDerecha), mover(MovimientoIzquierda), etc.

2. El jugador cuando recibe el mensaje mover, copia su posici�n actual en posici�nAnterior. Para evitar repetir c�digo, se puede hacer:
mover(Movimiento unMovimiento){
	posicionAnterior.setx(posicion.x());
	posicionAnterior.sety(posicion.y());
	moverPrivado(unMovimiento); 
	// moverPrivado manejar�a el tipo espec�fico de movimiento.
}

3. El moverPrivado, o como se valla a llamar, modifica la posici�n. La posici�n a la que tiene acceso el jugador deber�a ser la de la esquina en la que est� (osea, el jugador no tiene porque saber que tiene que aumentar la posici�n en 2 y no en 1). Luego de eso, moverPrivado env�a el mensaje notificarMovimiento al GPS.

4. El GPS tambi�n tiene sobrecargados diferentes m�todos notificarMovimiento (ya se, ya se, si se les ocurre algo mejor me avisan). notificarMovimiento toma la posici�n actual (la que reci�n fue modificada por jugador), y dependiendo del m�todo que reaccion�, le manda el mensaje interactuarCon(jugador) a un evento diferente. Por ejemplo, si Movimiento es del tipo MovimientoDerecha, tiene que activar el evento en el x actual menos uno. Si Movimiento fuese del tipo MovimientoIzquierda, tiene que activar el evento en x actual mas uno.

Una cosa sobre el mapa. Yo dir�a que los eventos se guarden en una matriz. Si el mapa es conceptualmente de 20x20, la matriz ser�a de 40x40, con eventos entre medio de cada esquina. Por ejemplo, si se llama a notificarMovimiento con un MovimientoDerecha como par�metro, y el GPS ve que posicion.x y posicion.y devuelven 5 y 4 respectivamente, entonces se activa el evento en (x,y) = ((5*2)-1, (4*2)). De nuevo... ya se que no es lindo, pero es m�s feo que el Jugador tenga  que saber que tiene que aumentar la posici�n en 2, y que desde afuera todo el mundo tenga que dividir la posici�n por 2.

5. El interactuarCon(Jugador) puede hacer varias cosas: si es una bonificaci�n o penalizaci�n, solo tiene que aumentar o disminuir los movimientos del jugador. Si es un obst�culo, env�a el mensaje cruzar(this) obst�culo al jugador. El jugador delega el cruzar al veh�culo, y el cruzar del veh�culo aumenta los movimientos del jugador. Para el que quiera saber porqu� el jugador tiene un vehiculo y no al rev�s como arreglamos... piensen como implementar un cambio de veh�culo con el dise�o en el que quedamos hoy en clase. Si se les ocurre me cuentan.

6. Si no se puede cruzar, el veh�culo le env�a el mensaje volverAtras al jugador, y el jugador solo tiene que modificar su posici�n sin subir ni bajar movimientos. Tambi�n se enviar�a vovlerAtras cuando notificarMovimiento recibe un movimiento inv�lido (por ejemplo, si el GPS ve que el movimiento que recibi� se sale de los l�mites, directamente env�a volverAtras
sin activar ning�n evento).

7. Yo dir�a que en todos los caminos en los que no hay eventos como bonificaciones, o penalizaciones, o lo que sea, haya un evento MovimientoSimple que solo aumenta los movimientos del jugador y nada m�s. As� cuando el jugador no puede mover por alg�n obst�culo o algo, no se le cuentan movimientos.

8. En la posici�n final (la meta), habr�a un evento MetaAlcanzada que al interactuar con el jugador toma su nombre y su puntuaci�n y los guarda, termina el juego, y otras cosas que tenga que hacer.

Resta pensar como inicializar veh�culos con referencias al jugador. Yo dir�a un patr�n Factory con un enumerado estilo Java. Para conseguir una moto, por ejemplo, ser�a: FabricaVehiculos.MOTOCICLETA.crearPara(jugador), o algo parecido.
FabricaVehiculos y Vehiculo estar�an en el mismo paquete. El constructor de veh�culo tendr�a visibilidad de paquete y solo se deber�a poder obtener veh�culos a partir de la f�brica.

