package modelo.mapa.eventos;

import modelo.jugador.Jugador;

public class MovimientoInvalido implements Evento {

    @Override
    public void interactuarCon(Jugador jugador) {
        jugador.volverAtras();
    }

}
