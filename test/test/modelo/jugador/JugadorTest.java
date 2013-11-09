package test.modelo.jugador;

import static org.junit.Assert.*;

import modelo.jugador.Jugador;
import modelo.jugador.Posicion;
import modelo.mapa.Mapa;
import modelo.mapa.eventos.Evento;
import modelo.mapa.eventos.MovimientoInvalido;
import modelo.mapa.eventos.MovimientoSimple;

import org.junit.Test;

public class JugadorTest {

    private class MapaMockMovimientoSimple extends Mapa {
        public Evento eventoEnPosicion(int x, int y){
            return new MovimientoSimple();
        }
    }
    
    private class MapaMockMovimientoInvalido extends Mapa {
        public Evento eventoEnPosicion(int x, int y){
            return new MovimientoInvalido();
        }
    }
    
    @Test
    public void test_posicionCorrecta(){
        Posicion posicionInicial = new Posicion(2, 4);
        Jugador jugador = new Jugador(null, posicionInicial, null);
        
        assertEquals(jugador.getPosicion().x(), 2);
        assertEquals(jugador.getPosicion().y(), 4);
    }
    
    @Test
    public void test_sumarMovimientos(){
        Posicion posicion = new Posicion(0, 0);
        Jugador jugador = new Jugador(null, posicion, null);
        jugador.sumarMovimientos(1);
        
        assertEquals(jugador.getMovimientos(), 1);
    }
    
    @Test
    public void test_movimientoSimple(){
        Posicion posicionInicial = new Posicion(2, 2);
        Mapa mapa = new MapaMockMovimientoSimple();
        Jugador jugador = new Jugador(mapa, posicionInicial, null);
        
        jugador.moverDerecha();
        
        assertEquals(jugador.getPosicion().x(), 4);
        assertEquals(jugador.getPosicion().y(), 2);
        assertEquals(jugador.getMovimientos(), 1);
    }
    
    @Test
    public void test_movimientoInvalido(){
        Posicion posicionInicial = new Posicion(2, 2);
        Mapa mapa = new MapaMockMovimientoInvalido();
        Jugador jugador = new Jugador(mapa, posicionInicial, null);
        
        jugador.moverDerecha();
        
        assertEquals(jugador.getPosicion().x(), 2);
        assertEquals(jugador.getPosicion().y(), 2);
        assertEquals(jugador.getMovimientos(), 0);
    }

}
