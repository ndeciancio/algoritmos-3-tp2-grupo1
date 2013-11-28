package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelGanaste;
import modelo.juego.Juego;
import modelo.juego.Jugador;

public class ControladorBotonMoverAbajo implements ActionListener {
    
    FramePrincipal framePrincipal;
    Jugador jugador;

    public ControladorBotonMoverAbajo(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
        jugador = Juego.getInstance().getJugador();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        jugador.moverAbajo();
        actualizarVista();
    }
    
    private void actualizarVista(){
        if(jugador.estaEnLaMeta())
            framePrincipal.setPanel(new PanelGanaste(framePrincipal));
        else
            framePrincipal.actualizar();
    }
    
}
