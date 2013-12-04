package modelo.evento.obstaculos;

import controladores.ControladorSonido;
import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public class ControlPolicial extends Obstaculo {
    
    private ControladorSonido player= new ControladorSonido("Sonidos/Don't Point That Thing.mp3");
    
    public ControlPolicial(Posicion posicion){
        super(posicion);    
    }

    @Override
    public void interactuarCon(Jugador jugador){
        jugador.getMovil().cruzarControlPolicial(jugador);
        player.play();
    }
    
    @Override
    public String toString(){
        return "ControlPolicial";
    }
    
    @Override 
    public Evento copiar(){
        return new ControlPolicial(posicion);
    }

}