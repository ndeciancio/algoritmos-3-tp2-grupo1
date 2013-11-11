package modelo.moviles;

import modelo.juego.Jugador;

public final class CuatroXCuatro implements Movil {
    
    @Override
    public void cruzarBache(Jugador jugador){
        jugador.sumarMovimientos(1);
    }
    
    @Override
    public void cruzarControlPolicial(Jugador jugador){   
        jugador.sumarMovimientos(1);
        if(Math.random() < 0.5)
            jugador.sumarMovimientos(3);
    }
    
    @Override
    public void cruzarPiquete(Jugador jugador){
        jugador.volverAtras();
    }


}
