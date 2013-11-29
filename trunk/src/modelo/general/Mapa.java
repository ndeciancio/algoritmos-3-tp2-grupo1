package modelo.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.evento.Evento;
import modelo.evento.MetaAlcanzada;



public class Mapa {

	private static Mapa singleton;

	private List<Evento> eventos = new ArrayList<Evento>();
	private Integer dimensionEnX;
	private Integer dimensionEnY;
	Evento meta;

	private Mapa(){
	    ponerPorDefecto();
	}
	
	public void setAncho(int ancho){
	    this.dimensionEnX = Integer.valueOf(ancho);
	}
	
	public void setAlto(int alto){
        this.dimensionEnY = Integer.valueOf(alto);
    }

	public static Mapa getInstance() {
		if (singleton == null) {
			singleton = new Mapa();
		}
		return singleton;
	}
	
	public int getAncho(){
	    return dimensionEnX.intValue();
	}
	
	public int getAlto(){
	    return dimensionEnY.intValue();
	}
	
	public List<Evento> getEventos() {
	    return eventos;
	}
	
	public void addEvento(Evento e) {
	    Posicion posicionDeEvento = e.getPosicion();
	    if (this.getEvento(posicionDeEvento) == null){
	    eventos.add(e);
	    }
	}
	
	public boolean tieneEvento(){
		return eventos.isEmpty();
	}
	
	public boolean tieneEvento(Posicion posicion){
		return (this.getEvento(posicion) != null);
	}
	
	public Evento getEvento(Posicion posicion){
		Evento event = null;
		Iterator<Evento> it = eventos.iterator();
		while (it.hasNext()) {
			Evento evento = it.next();
			if (evento.getPosicion().equals(posicion))
				event = evento;
		}
		return event;
	}

    public void ponerPorDefecto(){
        // Dimensiones por defecto.
        this.dimensionEnX = 20;
        this.dimensionEnY = 20;
        limpiarEventos();
        generarMeta();
    }
    
    public void limpiarEventos(){
        eventos.clear();
    }
	    
    public boolean hayMapaEnX(Posicion posicion){
    	return ((posicion.getCoordenadaX() >= 0) && (posicion.getCoordenadaX() < this.dimensionEnX));
    }

    public boolean hayMapaEnY(Posicion posicion){
    	return ((posicion.getCoordenadaY() >= 0) && (posicion.getCoordenadaY() < this.dimensionEnY));
    }
    
    public void generarMeta(){
        this.generarMeta(getPosicionAlAzar());
    }
    
    public void generarMeta(Posicion posicion){
        MetaAlcanzada meta = new MetaAlcanzada();
        meta.setPosicion(posicion);
        this.addEvento(meta);
        this.meta = meta;
    }
    
    public Posicion getPosicionDeLaMeta(){
        return meta.getPosicion();
    }
    
    public Posicion getPosicionAlAzar(){
        int posicionEnX = generarEnteroAlAzarEntreCeroY(dimensionEnX - 1);
        int posicionEnY = generarEnteroAlAzarEntreCeroY(dimensionEnY - 1);
        return new Posicion(posicionEnX, posicionEnY);
    }
    
    private int generarEnteroAlAzarEntreCeroY(int maximo){
        int entero = (int)(Math.random() * maximo + 1);
        if(entero%2 != 0 && entero != 0)
            entero--;
        return entero;
    }
    
}

