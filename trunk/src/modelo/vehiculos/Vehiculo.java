package modelo.vehiculos;

import modelo.jugador.Jugador;

public interface Vehiculo {    
    public abstract void cruzarBache(Jugador jugador);
    public abstract void cruzarPiquete(Jugador jugador);
    public abstract void cruzarControlPolicial(Jugador jugador);
}
