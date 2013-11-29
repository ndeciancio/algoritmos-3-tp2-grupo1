package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelIngresarNombre;
import vista.componentes.PanelMapa;

public class ControladorBotonJugar implements ActionListener {

    FramePrincipal framePrincipal;
    
    public ControladorBotonJugar(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        framePrincipal.setPanel(new PanelMapa(framePrincipal));
    }
    
}