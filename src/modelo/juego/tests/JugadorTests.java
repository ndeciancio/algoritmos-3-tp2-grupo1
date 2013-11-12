package modelo.juego.tests;

import static org.junit.Assert.*;

import modelo.general.Posicion;
import modelo.juego.Jugador;
import modelo.moviles.Automovil;

import org.junit.Test;

public class JugadorTests {

	@Test
	public void testUnJugadorDeberiaPoderMoverALaDerecha(){
		Posicion unaPosicion = new Posicion(1,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unJugador.moverDerecha();
		assertEquals(unJugador.getPosicionActual().getCoordenadaX(), new Integer(198736));
		
		
	}

}
