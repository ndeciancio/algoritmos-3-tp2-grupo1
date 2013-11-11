package modelo.evento.sorpresas;

import modelo.general.Posicion;
import modelo.juego.Jugador;

public class RotacionDeVehiculo extends Sorpresa {

    public RotacionDeVehiculo(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void interactuarCon(Jugador jugador) {
        jugador.getMovil().rotarMovil(jugador);        
    }

}
