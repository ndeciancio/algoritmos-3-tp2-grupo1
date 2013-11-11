package modelo.general;

import java.util.ArrayList;
import java.util.List;

import modelo.evento.Evento;



public class Mapa {

	private static Mapa singleton;

	private List<Evento> eventos = new ArrayList<Evento>();
	private Integer dimensionEnX = 800;
	private Integer dimensionEnY = 600;

	private Mapa() {
	}

	public static Mapa getInstance() {
		if (singleton == null) {
			singleton = new Mapa();
		}
		return singleton;
	}
	
	public void addEvento(Evento e) {
		eventos.add(e);
	}
	
}

