package modelo.evento.obstaculos;

import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public class Piquete extends Obstaculo {
    
    public Piquete(Posicion posicion){
        super(posicion);    
    }

    @Override
    public void interactuarCon(Jugador jugador){
        jugador.getMovil().cruzarPiquete(jugador);
    }
    
    @Override
    public String toString(){
        return "Piquete";
    }
    
    @Override 
    public Evento copiar(){
        return new Piquete(posicion);
    }

}
