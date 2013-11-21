package modelo.persistencia.tests;

import static org.junit.Assert.*;

import modelo.persistencia.TablaDePuntuaciones;

import org.junit.Test;


public class TablaDePuntuacionesTest {

	@Test
	public void test_agregarPuntuaciones(){
		TablaDePuntuaciones tabla = new TablaDePuntuaciones();
		
		tabla.ingresar("Fulano", 2);
		tabla.ingresar("Mengano", 6);
		
		assertEquals(tabla.entradaEnPosicion(0).getNombre(), "Fulano");
		assertEquals(tabla.entradaEnPosicion(0).getPuntuacion(), 2);
		assertEquals(tabla.entradaEnPosicion(1).getNombre(), "Mengano");
		assertEquals(tabla.entradaEnPosicion(1).getPuntuacion(), 6);
		assertEquals(tabla.getCantidadDePuntuaciones(), 2);
	}
	
	@Test
	public void test_lasEntradasEntranEnOrdenDeMovimientos(){
		TablaDePuntuaciones tabla = new TablaDePuntuaciones();
		
		tabla.ingresar("Fulano", 6);
		tabla.ingresar("Mengano", 2);
		
		assertEquals(tabla.entradaEnPosicion(0).getPuntuacion(), 2);
		assertEquals(tabla.entradaEnPosicion(1).getPuntuacion(), 6);
	}
	
	@Test
	public void test_esIterable(){
		TablaDePuntuaciones tabla = new TablaDePuntuaciones();
		assertTrue(tabla instanceof Iterable);
	}

}
