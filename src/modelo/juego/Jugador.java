package modelo.juego;

import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.moviles.Movil;
import modelo.evento.Evento;

public class Jugador {

	private Integer movimientos;
	private Movil vehiculo;
	private Mapa unMapa = Mapa.getInstance();
	private Posicion posicionActual;
	private Posicion posicionAnterior;
	
	public Jugador(Posicion posicionInicial, Movil vehiculo){
        this.movimientos = 0;
        this.posicionActual = posicionInicial;
        this.posicionAnterior = new Posicion(posicionInicial);
        setMovil(vehiculo);		
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
    
	public void moverDerecha(){
        recordarPosicion();
        posicionActual.setx(posicionActual.getCoordenadaX() + 2);
        interactuarConEventoEnPosicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY());
	}
	
	public void moverIzquierda(){
		recordarPosicion();
        posicionActual.setx(posicionActual.getCoordenadaX() - 2);
        interactuarConEventoEnPosicion(posicionActual.getCoordenadaX()+1,posicionActual.getCoordenadaY());
	}

	public void moverArriba(){
        recordarPosicion();
        posicionActual.sety(posicionActual.getCoordenadaY() - 2);
        interactuarConEventoEnPosicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()+1);
	}

	public void moverAbajo(){
        recordarPosicion();
        posicionActual.sety(posicionActual.getCoordenadaY() + 2);
        interactuarConEventoEnPosicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()-1);
	}
	
    private void recordarPosicion(){
        posicionAnterior.setx(posicionActual.getCoordenadaX());
        posicionAnterior.sety(posicionActual.getCoordenadaY());
    }

    public void volverAtras(){
        this.posicionActual.setx(posicionAnterior.getCoordenadaX());
        this.posicionActual.sety(posicionAnterior.getCoordenadaY());
    }

    public void interactuarConEventoEnPosicion(int coordenadaX,int coordenadaY){
    	Posicion posicionEvento = new Posicion(coordenadaX,coordenadaY);
    	Evento unEvento = unMapa.getEvento(posicionEvento);
    	unEvento.interactuarCon(this);
    }
}
