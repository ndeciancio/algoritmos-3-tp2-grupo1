package modelo.evento.tests;

import static org.junit.Assert.*;

import modelo.general.*;
import modelo.juego.*;
import modelo.moviles.*;
import modelo.evento.obstaculos.*;
import modelo.evento.sorpresas.*;


import org.junit.Before;
import org.junit.Test;

public class EventoTest {

	@Before
	public void setUp(){
	    Mapa.getInstance().resetear();
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
	public void testUnJugadorDeberiaCambiarACuatroXCuatroSiAtraviezaUnaSorpresaConEseEfectoSiendoUnAutomovil(){
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
	
	@Test
	public void testUnJugadorDeberiaCambiarAMotoSiAtraviezaUnaSorpresaConEseEfectoSiendoUnaCuatroXCuatro(){
		Posicion posicionInicial = new Posicion(1,7);
		CuatroXCuatro unaCuatroXCuatro = new CuatroXCuatro();
		Jugador unJugador = new Jugador(posicionInicial,unaCuatroXCuatro);
		RotacionDeVehiculo unaRotacion = new RotacionDeVehiculo(new Posicion(2,7));
		Mapa.getInstance().addEvento(unaRotacion);
		Bache unBache = new Bache(new Posicion(3,8));
		Mapa.getInstance().addEvento(unBache);
		unJugador.moverDerecha();
		unJugador.moverAbajo();
		assertEquals(unJugador.getMovimientos(),new Integer(5));
	}
	
	@Test
	public void testUnJugadorDeberiaCambiarAAutomovilSiAtraiezaUnaSorpresaConEseEfectoSiendoUnaMoto(){
		Posicion posicionInicial = new Posicion(1,7);
		Moto unaMoto = new Moto();
		Jugador unJugador = new Jugador(posicionInicial,unaMoto);
		RotacionDeVehiculo unaRotacion = new RotacionDeVehiculo(new Posicion(2,7));
		Mapa.getInstance().addEvento(unaRotacion);
		Bache unBache = new Bache(new Posicion(3,8));
		Mapa.getInstance().addEvento(unBache);
		unJugador.moverDerecha();
		unJugador.moverAbajo();
		assertEquals(unJugador.getMovimientos(),new Integer(5));
	}
	
	@Test
	public void testUnJugadorDeberiaSerPensalizadoCon3MovimientosMasSiCruzaConUnAutomovilUnBache(){
		Posicion posicionInicial = new Posicion(1,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		Bache unBache = new Bache(new Posicion(2,1));
		Mapa.getInstance().addEvento(unBache);
		unJugador.moverDerecha();
		assertEquals(unJugador.getMovimientos(),new Integer(4));
	}
	
	@Test
	public void testUnJugadorDeberiaCorrerRiesgoDeSerPenalizadoCon3MovimientosSiCruzaraUnControlPolicialConUnAutomovil(){
		Posicion posicionInicial = new Posicion(3,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		ControlPolicial unControl = new ControlPolicial(new Posicion(4,1));
		Mapa.getInstance().addEvento(unControl);
		unJugador.moverDerecha();
		if(unJugador.getMovimientos() > 2){
			assertEquals(unJugador.getMovimientos(),new Integer(4));
		}else{
			assertEquals(unJugador.getMovimientos(),new Integer(1));
		}
	}
	
	@Test
	public void testUnJugadorDeberiaDarLaVueltaSiIntentaraCruzarUnPiqueteConUnAuto(){
		Posicion posicionInicial = new Posicion(3,1);
		Automovil unAuto = new Automovil();
		Jugador unJugador = new Jugador(posicionInicial,unAuto);
		Piquete unPiquete = new Piquete(new Posicion(3,2));
		Mapa.getInstance().addEvento(unPiquete);
		unJugador.moverAbajo();
		assertEquals(unJugador.getMovimientos(),new Integer(1));		
	}

	@Test
	public void testUnJugadorDeberiaSerPenalizadoCon3MovimientosMasSiCruzaConUnaMotoUnBache(){
		Posicion posicionInicial = new Posicion(1,1);
		Moto unaMoto = new Moto();
		Jugador unJugador = new Jugador(posicionInicial,unaMoto);
		Bache unBache = new Bache(new Posicion(2,1));
		Mapa.getInstance().addEvento(unBache);
		unJugador.moverDerecha();
		assertEquals(unJugador.getMovimientos(),new Integer(4));
	}

	@Test
	public void testUnJugadorDeberiaPoderAtravezarUnPiqueteConUnaPenalizacionDe2MovimientosSiCruzaraConUnaMoto(){
		Posicion posicionInicial = new Posicion(3,1);
		Moto unaMoto = new Moto();
		Jugador unJugador = new Jugador(posicionInicial,unaMoto);
		Piquete unPiquete = new Piquete(new Posicion(3,2));
		Mapa.getInstance().addEvento(unPiquete);
		unJugador.moverAbajo();
		assertEquals(unJugador.getMovimientos(),new Integer(3));
	}
	
	@Test
	public void testUnJugadorDeberiaTenerAltasProbabilidadesDeSerPenalizadoCon3MovimientosSiCruzaraConUnaMotoUnControlPolicial(){
		Posicion posicionInicial = new Posicion(3,1);
		Moto unaMoto = new Moto();
		Jugador unJugador = new Jugador(posicionInicial,unaMoto);
		ControlPolicial unControlPolicial = new ControlPolicial(new Posicion(4,1));
		Mapa.getInstance().addEvento(unControlPolicial);
		unJugador.moverDerecha();
		if (unJugador.getMovimientos() > 2){
			assertEquals(unJugador.getMovimientos(),new Integer(4));
		}else{
			assertEquals(unJugador.getMovimientos(),new Integer(1));
		}
	}

	@Test
	public void testUnJugadorDeberiaPoderAtravezarUnBacheSinPenalizacionSiLoHicieraConunaCuatroXCuatro(){
		Posicion posicionInicial = new Posicion(1,1);
		CuatroXCuatro unaCuatroXCuatro = new CuatroXCuatro();
		Jugador unJugador = new Jugador(posicionInicial,unaCuatroXCuatro);
		Bache unBache = new Bache(new Posicion(2,1));
		Mapa.getInstance().addEvento(unBache);
		unJugador.moverDerecha();
		assertEquals(unJugador.getMovimientos(),new Integer(1));
	}
	
	@Test
	public void testUnJugadorDeberiaTenerLasMasbajasProbabilidadesDeSerPenalizadoCon3MovimientosSiCruzaraConUnaCuatroXCuatroUnControlPolicial(){
		Posicion posicionInicial = new Posicion(3,1);
		CuatroXCuatro unaCuatroXCuatro = new CuatroXCuatro();
		Jugador unJugador = new Jugador(posicionInicial,unaCuatroXCuatro);
		ControlPolicial unControl = new ControlPolicial(new Posicion(4,1));
		Mapa.getInstance().addEvento(unControl);
		unJugador.moverDerecha();
		if(unJugador.getMovimientos() > 2){
			assertEquals(unJugador.getMovimientos(),new Integer(4));
		}else{
			assertEquals(unJugador.getMovimientos(),new Integer(1));
		}
	}

	@Test
	public void testUnJugadorDeberiaDarLaVueltaSiIntentaCruzarUnPiqueteConUnaCuatroXCuatro(){
		Posicion posicionInicial = new Posicion(3,1);
		CuatroXCuatro unaCuatroXCuatro = new CuatroXCuatro();
		Jugador unJugador = new Jugador(posicionInicial,unaCuatroXCuatro);
		Piquete unPiquete = new Piquete(new Posicion(3,2));
		Mapa.getInstance().addEvento(unPiquete);
		unJugador.moverAbajo();
		assertEquals(unJugador.getMovimientos(),new Integer(1));
	}
	
}
