package controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.juego.Juego;
import modelo.juego.Jugador;
import vista.componentes.FrameOpciones;
import vista.componentes.FramePrincipal;
import vista.componentes.PanelPerdiste;
import vista.componentes.PanelGanaste;

public class ControladorKeyListener implements KeyListener {
    
    FramePrincipal framePrincipal;
    
    private ControladorSonido player= new ControladorSonido("Sonidos/My granny.mp3");
    
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
            verificarMovimientos();
        }
        if( code == KeyEvent.VK_UP){
            jugador.moverArriba();
            verificarMovimientos();
        }
        if( code == KeyEvent.VK_LEFT){
            jugador.moverIzquierda();
            verificarMovimientos();
        }
        if( code == KeyEvent.VK_RIGHT){
            jugador.moverDerecha();
            verificarMovimientos();
        }
        if( code == KeyEvent.VK_ESCAPE){
            FrameOpciones frameOpciones = new FrameOpciones(framePrincipal);
            frameOpciones.mostrar();
        }
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
    
    private void verificarMovimientos(){
        int movimientosLimite = Juego.getInstance().getDificultad().getLimiteDeMovimientos();
        Juego juego = Juego.getInstance();
        Jugador jugador = juego.getJugador();
        int cantidadDeMovimientos = jugador.getMovimientos();
        if (cantidadDeMovimientos > movimientosLimite){
            framePrincipal.setPanel(new PanelPerdiste(framePrincipal));
            player.play();
        }
    }
}
