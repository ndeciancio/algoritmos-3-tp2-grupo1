package modelo.general.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import modelo.general.Posicion;

public class PosicionTest {

	@Test
	public void testUnaPosicionDeberiaTenerUnaCoordenadaEnX() {
		Posicion unaPosicion = new Posicion(1,2);
		assert(unaPosicion.getCoordenadaX() == 1);		
	}

	@Test
	public void testUnaPosicionDeberiaTenerUnaCoordenadaEnY(){
		Posicion unaPosicion = new Posicion(1,3);
		assert(unaPosicion.getCoordenadaY()== 3);
	}
	
	@Test
	public void testUnaPosicionDeberiaInicializarseConOtraPosicion(){
		Posicion unaPosicion = new Posicion(1,2);
		Posicion otraPosicion = new Posicion(unaPosicion);
		assertEquals(unaPosicion.getCoordenadaX(),otraPosicion.getCoordenadaX());
		assertEquals(unaPosicion.getCoordenadaY(),otraPosicion.getCoordenadaY());
	}

	@Test
	public void testUnaPosicionDeberiaPoderCambiarSuCoordenadaX(){
		Posicion unaPosicion = new Posicion(1,1);
		assert(unaPosicion.getCoordenadaX() == 1);
		unaPosicion.setx(2);
		assert(unaPosicion.getCoordenadaX() == 2);
	}
	
	@Test
	public void testUnaPosicionDeberiaPoderCambiarSuCoordenadaY(){
		Posicion unaPosicion = new Posicion(1,1);
		assert(unaPosicion.getCoordenadaY() == 1);
		unaPosicion.sety(2);
		assert(unaPosicion.getCoordenadaY() == 2);
	}
}
