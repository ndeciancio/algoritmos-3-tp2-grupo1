package modelo.evento.obstaculos;

import controladores.ControladorSonido;
import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

public class Bache extends Obstaculo{
    
    private ControladorSonido player= new ControladorSonido("Sonidos/Dadgum.mp3");
	
	public Bache(Posicion posicion){
		super(posicion);	
	}

    @Override
    public void interactuarCon(Jugador jugador){
        jugador.getMovil().cruzarBache(jugador);
        player.play();
    }
    
    @Override
    public String toString(){
        return "Bache";
    }
    
    @Override 
    public Evento copiar(){
        return new Bache(posicion);
    }

}
