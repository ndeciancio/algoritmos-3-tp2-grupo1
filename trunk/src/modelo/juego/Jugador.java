package modelo.juego;

import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.moviles.Movil;
import modelo.evento.Evento;

public class Jugador {

	//	private Mapa mapaDeJuego = Mapa.getInstance();
	private Integer movimientos;
	private Movil vehiculo;
	private Mapa unaMapa = Mapa.getInstance();
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
	}
	
	public void moverIzquierda(){
		recordarPosicion();
        posicionActual.setx(posicionActual.getCoordenadaX() - 2);
	}

	public void moverArriba(){
        recordarPosicion();
        posicionActual.sety(posicionActual.getCoordenadaY() + 2);
	}

	public void moverAbajo(){
        recordarPosicion();
        posicionActual.sety(posicionActual.getCoordenadaY() - 2);
	}
	
    private void recordarPosicion(){
        posicionAnterior.setx(posicionActual.getCoordenadaX());
        posicionAnterior.sety(posicionActual.getCoordenadaY());
    }

    public void volverAtras(){
        this.posicionAnterior.setx(posicionAnterior.getCoordenadaX());
        this.posicionAnterior.sety(posicionAnterior.getCoordenadaY());
    }

}
