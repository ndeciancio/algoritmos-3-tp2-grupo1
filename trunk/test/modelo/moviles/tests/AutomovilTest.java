package modelo.moviles.tests;


import static org.junit.Assert.*;
import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.juego.Jugador;
import modelo.moviles.Automovil;
import modelo.moviles.CuatroXCuatro;

import org.junit.Before;
import org.junit.Test;

public class AutomovilTest {
	
	@Before
	public void setUp(){
		Mapa.getInstance().resetear();
	}
    
    @Test
	public void testAutomovilCruzarBache(){
		Posicion unaPosicion = new Posicion(1,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unAuto.cruzarBache(unJugador);
		assertEquals((int) unJugador.getMovimientos(),3);
	}
	
    @Test
	public void testAutomovilCruzarPiquete(){
		Posicion unaPosicion = new Posicion(1,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unJugador.moverAbajo();
		unAuto.cruzarPiquete(unJugador);
		assertTrue( (unJugador.getPosicionActual()).equals (unaPosicion) );
	}
    
    @Test
	public void testAutomovilRotarMovil(){
		Posicion unaPosicion = new Posicion(1,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(unaPosicion,unAuto);
		unAuto.rotarMovil(unJugador);
		assertTrue( (unJugador.getMovil()) instanceof CuatroXCuatro);
	}
    
}