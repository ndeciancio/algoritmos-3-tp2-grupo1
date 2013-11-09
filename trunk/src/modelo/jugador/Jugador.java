package modelo.jugador;

import modelo.mapa.Mapa;
import modelo.mapa.eventos.Evento;
import modelo.vehiculos.Vehiculo;

public class Jugador {

    private int movimientos;
    private Vehiculo vehiculo;
    private Mapa mapa;
    private Posicion posicion;
    private Posicion posicionAnterior;
    
    public Jugador(Mapa mapa, Posicion posicionInicial, Vehiculo vehiculo){
        this.movimientos = 0;
        this.mapa = mapa;
        this.posicion = posicionInicial;
        this.posicionAnterior = new Posicion(posicionInicial);
        setVehiculo(vehiculo);
    }
    
    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
    
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
    
    public Posicion getPosicion(){
        return posicion;
    }
    
    public int getMovimientos(){
        return movimientos;
    }
    
    public void sumarMovimientos(int movimientos){
        this.movimientos += movimientos;
    }
    
    public void moverDerecha(){
        recordarPosicion();
        posicion.setx(posicion.x() + 2);
        interactuarConEventoEn(posicion.x() - 1, posicion.y());
    }
    
    public void moverIzquierda(){
        recordarPosicion();
        posicion.setx(posicion.x() - 2);
        interactuarConEventoEn(posicion.x() + 1, posicion.y());
    }
    
    public void moverArriba(){
        recordarPosicion();
        posicion.sety(posicion.y() + 2);
        interactuarConEventoEn(posicion.x(), posicion.y() - 1);
    }
    
    public void moverAbajo(){
        recordarPosicion();
        posicion.sety(posicion.y() - 2);
        interactuarConEventoEn(posicion.x(), posicion.y() + 1);
    }
    
    private void recordarPosicion(){
        posicionAnterior.setx(posicion.x());
        posicionAnterior.sety(posicion.y());
    }
    
    private void interactuarConEventoEn(int x, int y){
        Evento elEvento = mapa.eventoEnPosicion(x, y);
        elEvento.interactuarCon(this);
    }
    
    public void volverAtras(){
        this.posicion.setx(posicionAnterior.x());
        this.posicion.sety(posicionAnterior.y());
    }
    
}
