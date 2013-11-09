package modelo.mapa.eventos.obstaculos;

import modelo.jugador.Jugador;
import modelo.mapa.eventos.Evento;

public class Piquete implements Evento {

    @Override
    public void interactuarCon(Jugador jugador) {
        jugador.getVehiculo().cruzarPiquete(jugador);        
    }
}
