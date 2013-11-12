package modelo.evento.tests;

import static org.junit.Assert.*;

import modelo.general.*;
import modelo.juego.*;
import modelo.moviles.*;
import modelo.evento.*;
import modelo.evento.obstaculos.*;
import modelo.evento.sorpresas.*;


import org.junit.Test;

public class EventoTests {

	@Test
	public void testUnJugadorDeberiaSerPensalizadoCon3MovimientosMasSiCruzaConnAutoUnBache(){
		Posicion posicionInicial = new Posicion(1,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		Bache unBache = new Bache(new Posicion(2,1));
		Mapa.getInstance().addEvento(unBache);
		unJugador.moverDerecha();
		assertEquals(unJugador.getMovimientos(),new Integer(4));
	}
	
	@Test
	public void testUnJugadorNoDeberiaSerPenalizadoSiCruzaLaSiguienteEsquinaYNoAtraviezaNingunObstaculoOSorpresa(){
		Posicion posicionInicial = new Posicion(1,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		unJugador.moverAbajo();
		assertEquals(unJugador.getMovimientos(),new Integer(1));		
	}

	@Test
	public void testUnJugadorDeberiaCorrerRiesgoDeSerPenalizadoCon3MovimientosSiCruzaraUnControlPolicialConUnAutomovil(){
		Posicion posicionInicial = new Posicion(3,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		ControlPolicial unControl = new ControlPolicial(new Posicion(4,1));
		Mapa.getInstance().addEvento(unControl);
		unJugador.moverDerecha();
		assertEquals(unJugador.getMovimientos(),new Integer(4));
	}

	@Test
	public void testUnJugadorDeberiaDarLaVueltaSiIntentaraCruzarUnPiqueteConUnAuto(){
		Posicion posicionInicial = new Posicion(3,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		Piquete unPiquete = new Piquete(new Posicion(3,2));
		Mapa.getInstance().addEvento(unPiquete);
		unJugador.moverAbajo();
		assertEquals(unJugador.getMovimientos(),new Integer(2));		
	}

	@Test
	public void testUnJugadorDeberiaSerPenalizadoConAumentoDeMovimientosSiCruzaraUnaSorpresaConEseEfecto(){
		Posicion posicionInicial = new Posicion(1,3);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		MovimientosAdicionales unaSorpresaPenalizadora = new MovimientosAdicionales(new Posicion(8,3));
		Mapa.getInstance().addEvento(unaSorpresaPenalizadora);
		unJugador.moverDerecha();
		unJugador.moverDerecha();
		unJugador.moverDerecha();
		unJugador.moverDerecha();
		assertEquals(unJugador.getMovimientos(),new Integer(5));
	}

	@Test
	public void testUnJugadorDeberiaSerRecompensadoConReduccionDeMovimientosSiCruzaraUnaSorpresaConEseEfecto(){
		Posicion posicionInicial = new Posicion(1,5);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		ReduccionDeMovimientos unaSorpresaFavorable = new ReduccionDeMovimientos(new Posicion(10,5));
		Mapa.getInstance().addEvento(unaSorpresaFavorable);
		unJugador.moverDerecha();
		unJugador.moverDerecha();
		unJugador.moverDerecha();
		unJugador.moverDerecha();
		unJugador.moverDerecha();
		assertEquals(unJugador.getMovimientos(),new Integer(4));
	}
	
	@Test
	public void testUnJugadorDeberiaCambiarAMotoSiAtraviezaUnaSorpresaConEseEfecto(){
		Posicion posicionInicial = new Posicion(1,7);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		RotacionDeVehiculo unaSorpresaDeRotacion = new RotacionDeVehiculo(new Posicion(2,7));
		Mapa.getInstance().addEvento(unaSorpresaDeRotacion);
		unJugador.moverDerecha();
		assertEquals(unJugador.getMovimientos(),new Integer(1));
		Bache unBache = new Bache(new Posicion(3,8));
		Mapa.getInstance().addEvento(unBache);
		unJugador.moverAbajo();
		assertEquals(unJugador.getMovimientos(),new Integer(2));
	}
}

