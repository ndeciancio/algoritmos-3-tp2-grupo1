package modelo.evento.sorpresas;

import modelo.evento.Evento;
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
    
    @Override
    public String toString(){
        return "MovimientosAdicionales";
    }
    
    @Override 
    public Evento copiar(){
        return new MovimientosAdicionales(posicion);
    }

}
