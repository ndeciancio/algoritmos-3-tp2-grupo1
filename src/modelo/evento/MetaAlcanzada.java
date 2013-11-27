package modelo.evento;

import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.persistencia.FachadaPersistencia;

public class MetaAlcanzada extends Evento {
    
    public MetaAlcanzada(){
    }
    
    @Override
    public void interactuarCon(Jugador jugador) {
        int puntuacion = calcularPuntuacion(jugador.getMovimientos());
        guardarPuntuacion(jugador.getNombre(), puntuacion);
    }
    
    private int calcularPuntuacion(int movimientos){
        return Juego.getInstance().getDificultad().calcularPuntuacion(movimientos);
    }
    
    private void guardarPuntuacion(String nombre, int puntuacion){
        FachadaPersistencia memory = new FachadaPersistencia();
        memory.nuevaPuntuacion(nombre, puntuacion);
        // Mandar la vista a la pantalla de victoria.
    }
    
    @Override
    public String toString(){
        return "Meta";
    }

}
