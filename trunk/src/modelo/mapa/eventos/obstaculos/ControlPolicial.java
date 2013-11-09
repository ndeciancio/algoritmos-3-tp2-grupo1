package modelo.mapa.eventos.obstaculos;

import modelo.jugador.Jugador;
import modelo.mapa.eventos.Evento;

public class ControlPolicial implements Evento {

    @Override
    public void interactuarCon(Jugador jugador) {
        jugador.getVehiculo().cruzarControlPolicial(jugador);        
    }
}
