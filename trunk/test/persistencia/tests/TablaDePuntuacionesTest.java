package persistencia.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import persistencia.TablaDePuntuaciones;

public class TablaDePuntuacionesTest {

	@Test
	public void test_agregarPuntuaciones(){
		TablaDePuntuaciones tabla = new TablaDePuntuaciones();
		
		tabla.ingresar("Fulano", 2);
		tabla.ingresar("Mengano", 6);
		
		assertEquals(tabla.entradaEnPosicion(0).getNombre(), "Fulano");
		assertEquals(tabla.entradaEnPosicion(0).getMovimientos(), 2);
		assertEquals(tabla.entradaEnPosicion(1).getNombre(), "Mengano");
		assertEquals(tabla.entradaEnPosicion(1).getMovimientos(), 6);
	}
	
	@Test
	public void test_lasEntradasEntranEnOrdenDeMovimientos(){
		TablaDePuntuaciones tabla = new TablaDePuntuaciones();
		
		tabla.ingresar("Fulano", 6);
		tabla.ingresar("Mengano", 2);
		
		assertEquals(tabla.entradaEnPosicion(0).getMovimientos(), 2);
		assertEquals(tabla.entradaEnPosicion(1).getMovimientos(), 6);
	}
	
	@Test
	public void test_esIterable(){
		TablaDePuntuaciones tabla = new TablaDePuntuaciones();
		assertTrue(tabla instanceof Iterable);
	}

}
