package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelComenzarPartida;

public class ControladorBotonPanelComenzarPartida implements ActionListener {
    
    FramePrincipal framePrincipal;

    public ControladorBotonPanelComenzarPartida(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        framePrincipal.setPanel(new PanelComenzarPartida(framePrincipal));
    }
    
}