package test.modelo.vehiculos;

import static org.junit.Assert.*;

import modelo.jugador.Jugador;
import modelo.jugador.Posicion;
import modelo.mapa.eventos.obstaculos.Bache;
import modelo.mapa.eventos.obstaculos.ControlPolicial;
import modelo.mapa.eventos.obstaculos.Piquete;
import modelo.vehiculos.Motocicleta;

import org.junit.Before;
import org.junit.Test;

public class MotocicletaTest {

    private Jugador jugador;
    
    @Before
    public void setUp(){
        Posicion posicion = new Posicion(0, 0);
        jugador = new Jugador(null, posicion, new Motocicleta());
    }
    
    @Test
    public void test_cruzarBache(){
        Bache obstaculo = new Bache();
        obstaculo.interactuarCon(jugador);
        
        assertEquals(jugador.getMovimientos(), 4);
    }
    
    @Test
    public void test_cruzarControlPolicial(){
        ControlPolicial obstaculo = new ControlPolicial();
        obstaculo.interactuarCon(jugador);
        
        assertTrue(jugador.getMovimientos() >= 1);
        if(jugador.getMovimientos() > 1)
            assertTrue(jugador.getMovimientos() == 4);
    }
    
    @Test
    public void test_cruzarPiquete(){
        Piquete obstaculo = new Piquete();
        obstaculo.interactuarCon(jugador);
        
        assertEquals(jugador.getMovimientos(), 3);
    }

}
