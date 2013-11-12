package modelo.moviles;

import modelo.juego.Jugador;

public final class Automovil implements Movil {

    @Override
    public void cruzarBache(Jugador jugador){
        jugador.sumarMovimientos(3);
    }
    
    @Override
    public void cruzarControlPolicial(Jugador jugador){
        if(Math.random() < 0.5)
            jugador.sumarMovimientos(3);
    }
    
    @Override
    public void cruzarPiquete(Jugador jugador){
        jugador.volverAtras();
    }
    
    @Override
    public void rotarMovil(Jugador jugador){
        jugador.setMovil(new CuatroXCuatro());
    }

}
