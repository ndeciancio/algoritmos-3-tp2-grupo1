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

<EDIT>
Despues de una charla en Skype con Horacio, surgi� un dise�o m�s simple (aunque tiene un par de cosas que no me convencen del todo). Ah� sub� el diagrama. Probablemente les guste m�s <.< aunque a mi no me convence que el auto sepa que tiene que mover de a dos; queda atado a la implementaci�n del mapa, cosa que el dise�o anterior trata de evitar. Igualmente lo charlamos ma�ana (hoy bah).
</EDIT>

<EDIT>
Al final... usemos mejor el dise�o simple y listo. Cualquier cosa lo arreglamos despu�s.
</EDIT>

No sub� diagrama de secuencia, pero les dejo la secuencia ac� en texto:

El jugador recibe alg�n mensaje moverDerecha(), moverIzquierda(), etc. Eso hace cambiar en 2 su posici�n en x o y. Luego le pide al mapa el evento entre esos puntos y manda el interactuarCon. No es necesario verificar si es un movimiento v�lido; cuando el jugador pide el evento al mapa en una posici�n fuera de rango, el mapa devolver�a un evento que al interactuar con el jugador le env�a el mensaje volverAtras() y nada m�s.

El interactuarCon(Jugador) puede hacer varias cosas: si es una bonificaci�n o penalizaci�n, solo tiene que aumentar o disminuir los movimientos del jugador. Si es un obst�culo, env�a el mensaje cruzar(this) obst�culo al jugador. El jugador delega el cruzar al veh�culo, y el cruzar del veh�culo aumenta los movimientos del jugador. Para el que quiera saber porqu� el jugador tiene un vehiculo y no al rev�s como arreglamos... piensen como implementar un cambio de veh�culo con el dise�o en el que quedamos hoy en clase. Si se les ocurre me cuentan.

Si no se puede cruzar, el veh�culo le env�a el mensaje volverAtras al jugador, y el jugador solo tiene que modificar su posici�n sin subir ni bajar movimientos. Tambi�n se enviar�a vovlerAtras cuando notificarMovimiento recibe una posici�n inv�lida.

Yo dir�a que en todos los caminos en los que no hay eventos como bonificaciones, o penalizaciones, o lo que sea, haya un evento MovimientoSimple que solo aumenta los movimientos del jugador y nada m�s. As� cuando el jugador no puede mover por alg�n obst�culo o algo, no se le cuentan movimientos.

En la posici�n final (la meta), habr�a un evento MetaAlcanzada que al interactuar con el jugador toma su nombre y su puntuaci�n y los guarda, termina el juego, y otras cosas que tenga que hacer.

Resta pensar como inicializar veh�culos con referencias al jugador. Yo dir�a un patr�n Factory con un enumerado estilo Java. Para conseguir una moto, por ejemplo, ser�a: FabricaVehiculos.MOTOCICLETA.crearPara(jugador), o algo parecido.
FabricaVehiculos y Vehiculo estar�an en el mismo paquete. El constructor de veh�culo tendr�a visibilidad de paquete y solo se deber�a poder obtener veh�culos a partir de la f�brica.

