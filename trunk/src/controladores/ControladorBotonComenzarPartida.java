package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelNuevaPartida;

public class ControladorBotonComenzarPartida implements ActionListener {

    FramePrincipal framePrincipal;
    
    public ControladorBotonComenzarPartida(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        framePrincipal.setPanel(new PanelNuevaPartida(framePrincipal));
    }
    
}
