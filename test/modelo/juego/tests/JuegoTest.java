package modelo.juego.tests;

import static org.junit.Assert.*;

import modelo.juego.Juego;

import org.junit.Test;

public class JuegoTest {

    @Test
    public void test_calculoDePuntajesEnModoFacil() {
        Juego juego = new Juego();
        juego.setDificultad(Juego.Dificultad.FACIL);
        
        assertEquals(juego.getDificultad().calcularPuntuacion(50), 30);
        assertEquals(juego.getDificultad().calcularPuntuacion(81), 0);
        assertTrue(juego.getDificultad().superaElLimiteDeMovimientos(81));
    }
    
    @Test
    public void test_calculoDePuntajesEnModoModerado() {
        Juego juego = new Juego();
        juego.setDificultad(Juego.Dificultad.MODERADO);
        
        assertEquals(juego.getDificultad().calcularPuntuacion(40), 20);
        assertEquals(juego.getDificultad().calcularPuntuacion(51), 0);
        assertTrue(juego.getDificultad().superaElLimiteDeMovimientos(51));
    }
    
    @Test
    public void test_calculoDePuntajesEnModoDificil() {
        Juego juego = new Juego();
        juego.setDificultad(Juego.Dificultad.DIFICIL);
        
        assertEquals(juego.getDificultad().calcularPuntuacion(30), 15);
        assertEquals(juego.getDificultad().calcularPuntuacion(36), 0);
        assertTrue(juego.getDificultad().superaElLimiteDeMovimientos(36));
    }

}
