package modelo.evento.obstaculos;

import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public class Bache extends Obstaculo{
	
	public Bache(Posicion posicion){
		super(posicion);	
	}

    @Override
    public void interactuarCon(Jugador jugador){
        jugador.getMovil().cruzarBache(jugador);
    }
    
    @Override
    public String toString(){
        return "Bache";
    }
    
    @Override 
    public Evento copiar(){
        return new Bache(posicion);
    }

}
