package modelo.moviles;

import modelo.juego.Jugador;

public final class Moto implements Movil {

    @Override
    public void cruzarBache(Jugador jugador){
        jugador.sumarMovimientos(3);
    }
    
    @Override
    public void cruzarControlPolicial(Jugador jugador){
        if(Math.random() < 0.8)
            jugador.sumarMovimientos(3);
    }
    
    @Override
    public void cruzarPiquete(Jugador jugador){
        jugador.sumarMovimientos(2);
    }
    
    @Override
    public void rotarMovil(Jugador jugador){
        jugador.setMovil(new Automovil());
    }
    
    @Override
    public String toString(){
        return "Moto";
    }
    
}
