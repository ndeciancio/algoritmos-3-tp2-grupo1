package modelo.evento.sorpresas;

import modelo.general.Posicion;
import modelo.juego.Jugador;

public class MovimientosAdicionales extends Sorpresa {
    
    public MovimientosAdicionales(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void interactuarCon(Jugador jugador) {
    	int movimientosSumados = jugador.getMovimientos() / 4;
        jugador.sumarMovimientos(movimientosSumados);
    }

}
