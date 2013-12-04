package modelo.evento.obstaculos;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import modelo.evento.Evento;
import modelo.general.Posicion;
import modelo.juego.Jugador;

import javazoom.jl.player.Player;

public class Piquete extends Obstaculo {
    
    Player player;
    
    public Piquete(Posicion posicion){
        super(posicion);
        try { 
            FileInputStream fis = new FileInputStream("Sonidos/Enemy Sighted.mp3"); 
            BufferedInputStream bis = new BufferedInputStream(fis); 
            player = new Player(bis); 
            } 
            catch (Exception e) { 
            System.out.println("Problem playing file " + "Sonidos/Enemy Sighted.mp3"); 
            System.out.println(e); 
            } 
    }

    @Override
    public void interactuarCon(Jugador jugador){
        jugador.getMovil().cruzarPiquete(jugador);
        try { player.play(); } 
        catch (Exception e) { System.out.println(e); } 
        
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
