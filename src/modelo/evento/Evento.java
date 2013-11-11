package modelo.evento;

import modelo.general.Posicion;
import modelo.juego.Jugador;

public abstract class Evento {
	
	protected Posicion posicion;

	public Posicion getPosicion(){
		return posicion;
	}
	
	public abstract void interactuarCon(Jugador jugador);
}