package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelIngresarNombre;

public class ControladorBotonSoyNuevo implements ActionListener {

    FramePrincipal framePrincipal;
    
    public ControladorBotonSoyNuevo(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        framePrincipal.setPanel(new PanelIngresarNombre(framePrincipal));
    }
    
}
