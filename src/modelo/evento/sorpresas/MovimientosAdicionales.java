package modelo.evento.sorpresas;

import controladores.ControladorSonido;
import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public class MovimientosAdicionales extends Sorpresa {
    
    private ControladorSonido player= new ControladorSonido("Sonidos/Enemy.mp3");
    
    public MovimientosAdicionales(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void interactuarCon(Jugador jugador) {
    	int movimientosSumados = jugador.getMovimientos() / 4;
        jugador.sumarMovimientos(movimientosSumados);
        player.play();
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
