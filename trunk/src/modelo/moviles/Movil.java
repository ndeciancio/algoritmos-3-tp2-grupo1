package modelo.moviles;

import modelo.juego.Jugador;

public interface Movil {
    public void cruzarBache(Jugador jugador);
    public void cruzarPiquete(Jugador jugador);
    public void cruzarControlPolicial(Jugador jugador);
}
