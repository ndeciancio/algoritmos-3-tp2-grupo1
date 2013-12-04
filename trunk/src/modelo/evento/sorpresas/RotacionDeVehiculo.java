package modelo.evento.sorpresas;

import controladores.ControladorSonido;
import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public class RotacionDeVehiculo extends Sorpresa {
    
    private ControladorSonido player= new ControladorSonido("Sonidos/Wololo.mp3");

    public RotacionDeVehiculo(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void interactuarCon(Jugador jugador) {
    	jugador.getMovil().rotarMovil(jugador);
    	player.play();
    }
    
    @Override
    public String toString(){
        return "RotacionDeVehiculo";
    }
    
    @Override 
    public Evento copiar(){
        return new RotacionDeVehiculo(posicion);
    }

}
