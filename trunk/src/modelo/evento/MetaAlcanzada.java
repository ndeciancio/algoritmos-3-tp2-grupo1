package modelo.evento;

import controladores.ControladorSonido;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.persistencia.FachadaPersistencia;

public class MetaAlcanzada extends Evento {
    
    private ControladorSonido player= new ControladorSonido("Sonidos/Herb laugh.mp3");
    
    public MetaAlcanzada(){
    }
    
    @Override
    public void interactuarCon(Jugador jugador) {
        int puntuacion = calcularPuntuacion(jugador.getMovimientos());
        guardarPuntuacion(jugador.getNombre(), puntuacion);
        player.play();
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
        return "MetaAlcanzada";
    }
    
    @Override 
    public Evento copiar(){
        return new MetaAlcanzada();
    }

}
