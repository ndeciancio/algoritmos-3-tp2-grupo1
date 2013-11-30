package controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.juego.Juego;
import modelo.juego.Jugador;
import vista.componentes.FramePrincipal;
import vista.componentes.PanelGanaste;

public class ControladorKeyListener implements KeyListener {
    
    FramePrincipal framePrincipal;
    
    public ControladorKeyListener(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }

    @Override 
    public void keyPressed(KeyEvent e)
    {
        Juego juego = Juego.getInstance();
        Jugador jugador = juego.getJugador();
        int code = e.getKeyCode();
        if( code == KeyEvent.VK_DOWN){
            jugador.moverAbajo();
            
        }
        if( code == KeyEvent.VK_UP){
            jugador.moverArriba();
        }
        if( code == KeyEvent.VK_LEFT){
            jugador.moverIzquierda();
        }
        if( code == KeyEvent.VK_RIGHT){
            jugador.moverDerecha();
        }
        framePrincipal.revalidate();
        framePrincipal.repaint();
        if(jugador.estaEnLaMeta())
            framePrincipal.setPanel(new PanelGanaste(framePrincipal));
        else
            framePrincipal.actualizar();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        
    }
              
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }

}
