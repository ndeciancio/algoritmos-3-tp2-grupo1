package persistencia;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TablaDePuntuaciones implements Iterable<TablaDePuntuaciones.Entrada> {
	
	private List<Entrada> puntuaciones;
	
	public TablaDePuntuaciones(){
		puntuaciones = new LinkedList<Entrada>();
	}
	
	public void ingresar(String nombre, int movimientos){
		Entrada nuevaEntrada = new Entrada(nombre, movimientos);
		puntuaciones.add(nuevaEntrada);
		Collections.sort(puntuaciones);
	}
	
	public Entrada entradaEnPosicion(int posicion){
		return puntuaciones.get(posicion);
	}
	
	public int getCantidadDePuntuaciones(){
	    return puntuaciones.size();
	}
	
	@Override
	public Iterator<Entrada> iterator(){
		return puntuaciones.iterator();
	}

	public class Entrada implements Comparable<Entrada> {
		private String nombre;
		private int puntuacion;
		
		Entrada(String nombre, int movimientos){
			this.nombre = nombre;
			this.puntuacion = movimientos;
		}
		
		public String getNombre(){
			return nombre;
		}
		
		public int getPuntuacion(){
			return puntuacion;
		}
		
		public int compareTo(Entrada referencia){
			return Integer.compare(puntuacion, referencia.getPuntuacion());
		}
	}
	
}
