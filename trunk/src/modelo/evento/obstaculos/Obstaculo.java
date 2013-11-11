package modelo.evento.obstaculos;

import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public abstract class Obstaculo extends Evento {
	
	public Obstaculo(Posicion posicion){
		this.posicion = posicion;
	}
	
	public abstract void interactuarCon(Jugador jugador);
}
