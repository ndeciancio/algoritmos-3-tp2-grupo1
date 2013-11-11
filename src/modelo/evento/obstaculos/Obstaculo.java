package modelo.evento.obstaculos;

import modelo.evento.Evento;
import modelo.general.Posicion;

public abstract class Obstaculo extends Evento {
	
	public Obstaculo(Posicion posicion){
		this.posicion = posicion;
	}
}
