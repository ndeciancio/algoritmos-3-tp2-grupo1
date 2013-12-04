package modelo.evento.sorpresas;

import controladores.ControladorSonido;
import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public class ReduccionDeMovimientos extends Sorpresa {
    
    private ControladorSonido player= new ControladorSonido("Sonidos/Ally.mp3");

    public ReduccionDeMovimientos(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void interactuarCon(Jugador jugador) {
    	int movimientosRestados = jugador.getMovimientos() / 5;
        jugador.sumarMovimientos(-movimientosRestados);
        player.play();
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
