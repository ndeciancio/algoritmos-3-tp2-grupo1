package modelo.general;

import java.util.ArrayList;
import java.util.List;

import modelo.obstaculos.Obstaculo;
import modelo.sorpresas.Sorpresa;


public class Mapa {

	private static Mapa singleton;

	private List<Obstaculo> obstaculos = new ArrayList<Obstaculo>();
	private List<Sorpresa> sorpresas = new ArrayList<Sorpresa>();
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
	
	public void addObstaculo(Obstaculo o) {
		obstaculos.add(o);
	}
	
	public void addSorpresa(Sorpresa s) {
		sorpresas.add(s);
	}
}

