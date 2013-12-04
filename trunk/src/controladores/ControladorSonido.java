package controladores;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class ControladorSonido { 
private String filename; 
private Player player; 

// constructor que toma el nombre el arhivo MP3 
public ControladorSonido(String filename) { 
    this.filename = filename; 
    } 

    public void close() { 
        if (player != null) 
        player.close(); 
        } 


    // reproduce el mp3 en la tarjeta de sonido predterminada 
    public void play() { 
        try { 
            FileInputStream fis = new FileInputStream(filename); 
            BufferedInputStream bis = new BufferedInputStream(fis); 
            player = new Player(bis); 
        } 
        catch (Exception e) { 
            System.out.println("Problem playing file " + filename); 
            System.out.println(e); 
        } 
        
        // correo el proceso en un nuevo hilo para deterner la ejecucion del programa 
        new Thread() { 
            public void run() { 
                try { player.play(); } 
                catch (Exception e) { System.out.println(e); } 
            } 
        }.start(); 
    
    }
}
