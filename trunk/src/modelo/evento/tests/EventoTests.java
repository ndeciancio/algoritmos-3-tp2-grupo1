package modelo.evento.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import modelo.general.*;
import modelo.evento.obstaculos.*;
import modelo.moviles.*;
import modelo.juego.*;


public class EventoTests {

	@Test
	public void testUnJugadorDeberiaSerPenalizadoSiAtraviezaUnBache() {
		Posicion posicionInicial = new Posicion(2,2);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		Bache unBache = new Bache(new Posicion(3,2));
		Mapa.getInstance().addEvento(unBache);
		unJugador.moverDerecha();
		assertEquals(unJugador.getMovimientos(),new Integer(4));	
	}
	
	@Test
	public void testUnJugadorPodriaCruzarUnaCalleSinObstaculosNiSopresas(){
		Posicion posicionInicial = new Posicion(2,2);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		unJugador.moverDerecha();
		assertEquals(unJugador.getMovimientos(),new Integer(1));	
	}
}
