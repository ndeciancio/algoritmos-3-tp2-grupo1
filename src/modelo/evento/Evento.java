package modelo.evento;

import modelo.general.Posicion;

public abstract class Evento {
	
	protected Posicion posicion;

	public Posicion getPosicion(){
		return posicion;
	}
	
}
