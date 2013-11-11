package modelo.moviles;

import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public abstract class Movil {

	private Posicion posicionActual;
	private Posicion posicionAnterior;
	private Jugador jugador;
	
	public Movil(Posicion posicionInicial){
		this.posicionActual = posicionInicial;
		this.posicionAnterior = new Posicion(posicionInicial);
	}
	
	public Posicion getPosicionActual(){
		return this.posicionActual;
	}
	
	public Posicion getPosicionAnterior(){
		return this.posicionAnterior;
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
