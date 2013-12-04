package modelo.evento.obstaculos;

import controladores.ControladorSonido;

import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;


public class Piquete extends Obstaculo {
    
    private ControladorSonido player= new ControladorSonido("Sonidos/Enemy Sighted.mp3");
    
    public Piquete(Posicion posicion){
        super(posicion);
    }

    @Override
    public void interactuarCon(Jugador jugador){
        jugador.getMovil().cruzarPiquete(jugador);
        this.player.play();
    }
    
    @Override
    public String toString(){
        return "Piquete";
    }
    
    @Override 
    public Evento copiar(){
        return new Piquete(posicion);
    }

}
