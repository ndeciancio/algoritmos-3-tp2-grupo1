package modelo.vehiculos;

import modelo.jugador.Jugador;

public class Automovil implements Vehiculo {

    @Override
    public void cruzarBache(Jugador jugador){
        jugador.sumarMovimientos(4);
    }
    
    @Override
    public void cruzarControlPolicial(Jugador jugador){
        jugador.sumarMovimientos(1);
        if(Math.random() < 0.3)
            jugador.sumarMovimientos(3);
    }
    
    @Override
    public void cruzarPiquete(Jugador jugador){
        jugador.volverAtras();
    }

}