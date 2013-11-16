package modelo.moviles.tests;

import static org.junit.Assert.*;
import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.juego.Jugador;
import modelo.moviles.Moto;
import modelo.moviles.Automovil;

import org.junit.Before;
import org.junit.Test;

public class MotoTest {

		@Before
			public void setUp(){
			Mapa.getInstance().resetear();
		}
		
	    @Test
		public void testMotoCruzarBache(){
			Posicion unaPosicion = new Posicion(1,1);
			Moto unaMoto = new Moto();
			Jugador unJugador = new Jugador(unaPosicion,unaMoto);
			unaMoto.cruzarBache(unJugador);
			assertEquals((int) unJugador.getMovimientos(),3);
		}
		
	    @Test
		public void testMotoCruzarPiqueteSumaMovimientos(){
			Posicion unaPosicion = new Posicion(1,1);
			Moto unaMoto = new Moto();
			Jugador unJugador = new Jugador(unaPosicion,unaMoto);
			unJugador.moverDerecha();
			unaMoto.cruzarPiquete(unJugador);
			assertEquals((int) unJugador.getMovimientos(),3);
		}
	    
	    @Test
	  	public void testMotoCruzarPiqueteJugadorCambiaDePosicion(){
	  		Posicion unaPosicion = new Posicion(1,1);
	  		Posicion posicionDerecha = new Posicion(3,1);
	  		Moto unaMoto = new Moto();
	  		Jugador unJugador = new Jugador(unaPosicion,unaMoto);
	  		unJugador.moverDerecha();
	  		unaMoto.cruzarPiquete(unJugador);
	  		assertTrue(unJugador.getPosicionActual().equals(posicionDerecha));	
	  	}
	    

	    @Test
		public void testMotoRotarMovil(){
			Posicion unaPosicion = new Posicion(1,1);
			Moto unaMoto = new Moto();
			Jugador unJugador = new Jugador(unaPosicion,unaMoto);
			unaMoto.rotarMovil(unJugador);
			assertTrue( (unJugador.getMovil()) instanceof Automovil);
		}
}
