package modelo.general.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.evento.obstaculos.Bache;
import modelo.general.Mapa;
import modelo.general.Posicion;

public class MapaTests {

	@Test
	public void testUnMapaPodriaTenerEventos() {
		Mapa unMapa = Mapa.getInstance();
		Posicion unaPosicion = new Posicion(1,1); 
		Bache unBache = new Bache(unaPosicion);
		unMapa.addEvento(unBache);
		assert(unMapa.tieneEvento());
	}

	@Test
	public void testUnMapaDeberiaConocerSiTieneUnEventoEnAlgunaPosicion(){
		Mapa unMapa = Mapa.getInstance();
		Posicion unaPosicion = new Posicion(1,3);
		Bache unBache = new Bache(unaPosicion);
		unMapa.addEvento(unBache);
		assertEquals(unMapa.getEvento(unaPosicion),unBache);
	}
	
	@Test
	public void testUnMapaPodriaTenerMasDeUnEvento(){
		Mapa unMapa = Mapa.getInstance();
		Posicion unaPosicion = new Posicion(1,1);
		Posicion otraPosicion = new Posicion(1,3);
		Bache unBache = new Bache(unaPosicion);
		Bache otroBache = new Bache(otraPosicion);
		unMapa.addEvento(unBache);
		unMapa.addEvento(otroBache);
		assertEquals(unMapa.getEvento(unaPosicion),unBache);
		assertEquals(unMapa.getEvento(otraPosicion),otroBache);
	}
	
}
