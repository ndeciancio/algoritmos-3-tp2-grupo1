package modelo.evento.sorpresas;

import modelo.evento.Evento;
import modelo.general.Posicion;

public abstract class Sorpresa extends Evento {
	
	public Sorpresa(Posicion posicion){
		this.posicion = posicion;
	}
	
}
