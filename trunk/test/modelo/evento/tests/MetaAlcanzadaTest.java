package modelo.evento.tests;

import static org.junit.Assert.*;

import modelo.evento.MetaAlcanzada;
import modelo.general.Posicion;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.moviles.Automovil;
import modelo.persistencia.FachadaPersistencia;
import modelo.persistencia.TablaDePuntuaciones;

import org.junit.Before;
import org.junit.Test;

public class MetaAlcanzadaTest {

    Juego juego;
    Jugador jugador;
    FachadaPersistencia memoryCard;
    
    @Before
    public void setUp(){
        jugador = new Jugador(new Posicion(0, 0), new Automovil());
        jugador.setNombre("Juancito");
        juego = Juego.getInstance();
        Juego.getInstance().ponerPorDefecto();
        juego.setDificultad(Juego.Dificultad.MODERADO);
        memoryCard = new FachadaPersistencia();
        memoryCard.borrarPuntuaciones();
    }
    
    @Test
    public void test_lasPartidasSeGuardanCorrectamente() {        
        MetaAlcanzada evento = new MetaAlcanzada();
        evento.interactuarCon(jugador);
        TablaDePuntuaciones tabla = memoryCard.cargarPuntuaciones();
        memoryCard.borrarPuntuaciones();
        
        assertEquals(tabla.entradaEnPosicion(0).getNombre(), jugador.getNombre());
    }

}
