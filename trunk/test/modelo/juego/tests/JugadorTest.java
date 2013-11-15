package modelo.juego.tests;

import static org.junit.Assert.*;

import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.juego.Jugador;
import modelo.moviles.Automovil;

import org.junit.Before;
import org.junit.Test;

public class JugadorTest {
    
    @Before
    public void setUp(){
        Mapa.getInstance().resetear();
    }
	
	@Test
	public void testUnJugadorDeberiaSaberEnQuePosicionSeEncuentra(){
		Posicion unaPosicion = new Posicion(1,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		assertTrue(unJugador.getPosicionAnterior().equals(new Posicion(1,1)));
	}
	
	@Test
	public void testUnJugadorDeberiaPoderMoverseHaciaLaDerecha(){
		Posicion unaPosicion = new Posicion(1,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unJugador.moverDerecha();
		Posicion posicionALaDerecha = new Posicion(3,1);
		assertTrue(unJugador.getPosicionActual().equals(posicionALaDerecha));	
	}
	
	@Test
	public void testUnJugadorDeberiaPoderMoverseHaciaLaizquierda(){
		Posicion unaPosicion = new Posicion(3,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unJugador.moverIzquierda();
		Posicion posicionALaIzquierda = new Posicion(1,1);
		assertTrue(unJugador.getPosicionActual().equals(posicionALaIzquierda));
	}

	@Test
	public void testUnJugadorDeberiaPoderMoverseHaciaArriba(){
		Posicion unaPosicion = new Posicion(3,3);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unJugador.moverArriba();
		Posicion posicionArriba = new Posicion(3,1);
		assertTrue(unJugador.getPosicionActual().equals(posicionArriba));
	}

	@Test
	public void testUnJugadorDeberiaPoderMoverseHaciaAbajo(){
		Posicion unaPosicion = new Posicion(3,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unJugador.moverAbajo();
		Posicion posicionAbajo = new Posicion(3,3);
		assertTrue(unJugador.getPosicionActual().equals(posicionAbajo));	
	}

	@Test
	public void testUnJugadorDeberiaConocerDondeEstabaDespuesDeMoverse(){
		Posicion unaPosicion = new Posicion(10,10);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unJugador.moverArriba();
		Posicion posicionAnterior = new Posicion(10,10);
		assertTrue(unJugador.getPosicionAnterior().equals(posicionAnterior));
	}

	@Test 
	public void testUnJugadorDeberiaPoderVolverHaciaAtrasUnaVezQueAvanzoEnAlgunaDireccion(){
		Posicion unaPosicion = new Posicion(5,5);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unJugador.moverDerecha();
		assertTrue(unJugador.getPosicionActual().equals(new Posicion(7,5)));
		unJugador.volverAtras();
		assertTrue(unJugador.getPosicionActual().equals(new Posicion(5,5)));
	}

	@Test
	public void testUnJugadorDeberiaRecordarLaPosicionAnteriorCuandoSeMueve(){
		Posicion unaPosicion = new Posicion(5,5);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unJugador.moverArriba();
		assertTrue(unJugador.getPosicionAnterior().equals(new Posicion(5,5)));
	}
}
