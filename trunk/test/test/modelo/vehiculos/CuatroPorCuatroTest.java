package test.modelo.vehiculos;

import static org.junit.Assert.*;

import modelo.jugador.Jugador;
import modelo.jugador.Posicion;
import modelo.mapa.eventos.obstaculos.Bache;
import modelo.mapa.eventos.obstaculos.ControlPolicial;
import modelo.mapa.eventos.obstaculos.Piquete;
import modelo.vehiculos.CuatroPorCuatro;

import org.junit.Before;
import org.junit.Test;

public class CuatroPorCuatroTest {

    private Jugador jugador;
    
    @Before
    public void setUp(){
        Posicion posicionInicial = new Posicion(0, 0);
        jugador = new Jugador(null, posicionInicial, new CuatroPorCuatro());
    }
    
    @Test
    public void test_cruzarBache(){
        Bache obstaculo = new Bache();
        obstaculo.interactuarCon(jugador);
        
        assertEquals(jugador.getMovimientos(), 1);
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
        int xInicial = jugador.getPosicion().x();
        int yInicial = jugador.getPosicion().y();
        Piquete obstaculo = new Piquete();
        obstaculo.interactuarCon(jugador);
        
        assertEquals(xInicial, jugador.getPosicion().x());
        assertEquals(yInicial, jugador.getPosicion().y());
        assertEquals(jugador.getMovimientos(), 0);
    }

}
