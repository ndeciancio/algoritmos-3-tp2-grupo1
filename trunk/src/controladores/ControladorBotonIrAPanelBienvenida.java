package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelBienvenida;

public class ControladorBotonIrAPanelBienvenida implements ActionListener {
    
    FramePrincipal framePrincipal;

    public ControladorBotonIrAPanelBienvenida(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        framePrincipal.setPanel(new PanelBienvenida(framePrincipal));
    }
    
}