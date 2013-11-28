package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelGanaste;
import modelo.juego.Juego;
import modelo.juego.Jugador;

public class ControladorBotonMoverIzquierda implements ActionListener {
    
    FramePrincipal framePrincipal;
    Jugador jugador;

    public ControladorBotonMoverIzquierda(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
        jugador = Juego.getInstance().getJugador();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        jugador.moverIzquierda();
        actualizarVista();
    }
    
    private void actualizarVista(){
        if(jugador.estaEnLaMeta())
            framePrincipal.setPanel(new PanelGanaste(framePrincipal));
        else
            framePrincipal.actualizar();
    }
    
}