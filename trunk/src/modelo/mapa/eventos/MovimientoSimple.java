package modelo.mapa.eventos;

import modelo.jugador.Jugador;

public class MovimientoSimple implements Evento {

    @Override
    public void interactuarCon(Jugador jugador) {
        jugador.sumarMovimientos(1);
    }

}
