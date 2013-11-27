package modelo.moviles.tests;

import static org.junit.Assert.*;
import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.juego.Jugador;
import modelo.moviles.CuatroXCuatro;
import modelo.moviles.Moto;

import org.junit.Before;
import org.junit.Test;

public class CuatroXCuatroTest {
	
		@Before
		public void setUp(){
			Mapa.getInstance().ponerPorDefecto();
		}
	    
	    @Test
		public void testCuatroXCuatroCruzarBache(){
			Posicion unaPosicion = new Posicion(1,1);
			CuatroXCuatro unaCuatroXCuatro = new CuatroXCuatro();
			Jugador unJugador = new Jugador(unaPosicion,unaCuatroXCuatro);
			unaCuatroXCuatro.cruzarBache(unJugador);
			assertEquals((int) unJugador.getMovimientos(),0);
		}
		
	    @Test
		public void testCuatroXCuatroCruzarPiquete(){
			Posicion unaPosicion = new Posicion(1,1);
			CuatroXCuatro unaCuatroXCuatro = new CuatroXCuatro();
			Jugador unJugador = new Jugador(unaPosicion,unaCuatroXCuatro);
			unJugador.moverAbajo();
			unaCuatroXCuatro.cruzarPiquete(unJugador);
			assertTrue( (unJugador.getPosicionActual()).equals(unaPosicion));
		}
	    
	    @Test
		public void testCuatroXCuatroRotarMovil(){
			Posicion unaPosicion = new Posicion(1,1);
			CuatroXCuatro unaCuatroXCuatro = new CuatroXCuatro();
			Jugador unJugador = new Jugador(unaPosicion,unaCuatroXCuatro);
			unaCuatroXCuatro.rotarMovil(unJugador);
			assertTrue( (unJugador.getMovil()) instanceof Moto);
		}
}
