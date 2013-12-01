package controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.juego.Juego;
import modelo.juego.Jugador;
import vista.componentes.FrameOpciones;
import vista.componentes.FramePrincipal;
import vista.componentes.PanelMapa;
import vista.componentes.PanelOpciones;
import vista.componentes.PanelPerdiste;
import vista.componentes.PanelGanaste;

public class ControladorKeyListener implements KeyListener {
    
    PanelMapa panelMapa;
    FrameOpciones frameOpciones;
    
    public ControladorKeyListener(PanelMapa panelMapa){
        this.panelMapa = panelMapa;
    }

    @Override 
    public void keyPressed(KeyEvent e)
    {
        FramePrincipal framePrincipal = this.panelMapa.getFramePrincipal();
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
            frameOpciones = new FrameOpciones();
            PanelOpciones opciones = new PanelOpciones(frameOpciones);
            opciones.setPanelMapa(panelMapa);
            frameOpciones.setPanel(opciones);
            frameOpciones.mostrar();
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
    private void verificarMovimientos(){
        int movimientosLimite = Juego.getInstance().getDificultad().getLimiteDeMovimientos();
        Juego juego = Juego.getInstance();
        Jugador jugador = juego.getJugador();
        int cantidadDeMovimientos = jugador.getMovimientos();
        if (cantidadDeMovimientos>movimientosLimite){
            this.panelMapa.getFramePrincipal().setPanel(new PanelPerdiste(this.panelMapa.getFramePrincipal()));
        }
    }
}
