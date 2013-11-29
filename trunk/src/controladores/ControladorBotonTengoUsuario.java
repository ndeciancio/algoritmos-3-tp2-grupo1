package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelElegirUsuario;

public class ControladorBotonTengoUsuario implements ActionListener {

    FramePrincipal framePrincipal;
    
    public ControladorBotonTengoUsuario(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        framePrincipal.setPanel(new PanelElegirUsuario(framePrincipal));
    }
    
}