package modelo.evento.obstaculos;

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

}
