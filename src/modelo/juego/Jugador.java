package modelo.juego;

import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.moviles.Automovil;
import modelo.moviles.Movil;
import modelo.evento.Evento;

public class Jugador {

	private Integer movimientos;
	private Movil vehiculo;
	private Mapa unMapa = Mapa.getInstance();
	private Posicion posicionActual;
	private Posicion posicionAnterior;
	private String nombre;
	
	public Jugador(Posicion posicionInicial, Movil vehiculo){
        this.movimientos = 0;
        this.posicionActual = posicionInicial;
        this.posicionAnterior = new Posicion(posicionInicial);
        this.nombre = "Anonimo";
        setMovil(vehiculo);		
	}
	
	public static Jugador crearPorDefecto(){
	    return new Jugador(new Posicion(0, 0), new Automovil());
	}
	
	public void setNombre(String nombre){
	    this.nombre = nombre;
	}
	
	public String getNombre(){
	    return nombre;
	}
	
    public Movil getMovil(){
    	return this.vehiculo;
    }
    
    public Posicion getPosicionActual(){
    	return this.posicionActual;
    }
    
    public Posicion getPosicionAnterior()
    {
    	return this.posicionAnterior;
    }
    
    public Integer getMovimientos(){
    	return this.movimientos;
    }
    
    public void sumarMovimientos(int movimientos){
        this.movimientos += movimientos;
    }
    
    public void setMovil(Movil vehiculo){
    	this.vehiculo = vehiculo;
    }
    
    public boolean puedeMoverse(Posicion posicion){
    	return ((this.unMapa.hayMapaEnX(posicion)) && (this.unMapa.hayMapaEnY(posicion)));
    }
    
	public void moverDerecha(){
        if(this.puedeMoverse(new Posicion(posicionActual.getCoordenadaX()+2,posicionActual.getCoordenadaY()))){	
			recordarPosicion();
	        posicionActual.setx(posicionActual.getCoordenadaX() + 2);
	        Posicion posicionEvento = new Posicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY());
	        if (unMapa.tieneEvento(posicionEvento)){
	        	this.movimientos++;
	        	interactuarConEventoEnPosicion(posicionEvento);	
	        }else{
	        	this.movimientos++;
	        }    
        }
     }
	
	public void moverIzquierda(){
        if(this.puedeMoverse(new Posicion(posicionActual.getCoordenadaX()-2,posicionActual.getCoordenadaY()))){
			recordarPosicion();
	        posicionActual.setx(posicionActual.getCoordenadaX() - 2);
	        Posicion posicionEvento = new Posicion(posicionActual.getCoordenadaX() + 1,posicionActual.getCoordenadaY());
	        if (unMapa.tieneEvento(posicionEvento)){
	        	this.movimientos++;
	        	interactuarConEventoEnPosicion(posicionEvento);
	        }else{
	        	this.movimientos++;
	        }
        }
	}

	public void moverArriba(){
        if(this.puedeMoverse(new Posicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()-2))){
			recordarPosicion();
	        posicionActual.sety(posicionActual.getCoordenadaY() - 2);
	        Posicion posicionEvento = new Posicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()+1);
	        if (unMapa.tieneEvento(posicionEvento)){
	        	this.movimientos++;
	        	interactuarConEventoEnPosicion(posicionEvento);
	        }else{
	        	this.movimientos++;
	        }
        }
	}

	public void moverAbajo(){
        if(this.puedeMoverse(new Posicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()+2))){
			recordarPosicion();
	        posicionActual.sety(posicionActual.getCoordenadaY() + 2);
	        Posicion posicionEvento = new Posicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()-1);
	        if (unMapa.tieneEvento(posicionEvento)){
	        	this.movimientos++;
	        	interactuarConEventoEnPosicion(posicionEvento);
	        }else{
	        	this.movimientos++;
	        }   
        }
	}
	
    private void recordarPosicion(){
        posicionAnterior.setx(posicionActual.getCoordenadaX());
        posicionAnterior.sety(posicionActual.getCoordenadaY());
    }

    public void volverAtras(){
        this.posicionActual.setx(posicionAnterior.getCoordenadaX());
        this.posicionActual.sety(posicionAnterior.getCoordenadaY());
    }

    public void interactuarConEventoEnPosicion(Posicion posicionEvento){
    	Evento unEvento = unMapa.getEvento(posicionEvento);
    	unEvento.interactuarCon(this);
    }
}
