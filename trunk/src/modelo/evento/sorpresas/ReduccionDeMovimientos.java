package modelo.evento.sorpresas;

import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public class ReduccionDeMovimientos extends Sorpresa {

    public ReduccionDeMovimientos(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void interactuarCon(Jugador jugador) {
    	int movimientosRestados = jugador.getMovimientos() / 5;
        jugador.sumarMovimientos(-movimientosRestados);
    }

    @Override
    public String toString(){
        return "ReduccionDeMovimientos";
    }
    
    @Override 
    public Evento copiar(){
        return new ReduccionDeMovimientos(posicion);
    }
    
}
