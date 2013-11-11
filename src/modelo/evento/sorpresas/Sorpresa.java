package modelo.evento.sorpresas;

import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public abstract class Sorpresa extends Evento {
	
	public Sorpresa(Posicion posicion){
		this.posicion = posicion;
	}
	
	public abstract void interactuarCon(Jugador jugador);
}
