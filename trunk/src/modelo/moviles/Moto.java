package modelo.moviles;

import modelo.juego.Jugador;

public final class Moto implements Movil {

    @Override
    public void cruzarBache(Jugador jugador){
        jugador.sumarMovimientos(4);
    }
    
    @Override
    public void cruzarControlPolicial(Jugador jugador){
        jugador.sumarMovimientos(1);
        if(Math.random() < 0.8)
            jugador.sumarMovimientos(3);
    }
    
    @Override
    public void cruzarPiquete(Jugador jugador){
        jugador.sumarMovimientos(3);
    }
    
    @Override
    public void rotarMovil(Jugador jugador){
        jugador.setMovil(new Automovil());
    }
    
}
