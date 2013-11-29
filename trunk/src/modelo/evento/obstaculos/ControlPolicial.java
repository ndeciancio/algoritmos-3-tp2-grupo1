package modelo.evento.obstaculos;

import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public class ControlPolicial extends Obstaculo {
    
    public ControlPolicial(Posicion posicion){
        super(posicion);    
    }

    @Override
    public void interactuarCon(Jugador jugador){
        jugador.getMovil().cruzarControlPolicial(jugador);
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