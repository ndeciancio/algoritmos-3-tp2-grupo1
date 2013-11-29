package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelPuntajes;

public class ControladorBotonVerPuntajes implements ActionListener {

    FramePrincipal framePrincipal;
    
    public ControladorBotonVerPuntajes(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        framePrincipal.setPanel(new PanelPuntajes(framePrincipal));
    }
    
}