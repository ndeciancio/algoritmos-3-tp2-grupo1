package controladores;

import java.awt.event.ActionEvent;

import vista.componentes.FrameOpciones;
import vista.componentes.FramePrincipal;
import vista.componentes.PanelBienvenida;

public class ControladorBotonIrAPanelBienvenidaDialogo extends ControladorBotonIrAPanelBienvenida {

    private FrameOpciones frameOpciones;
    
    public ControladorBotonIrAPanelBienvenidaDialogo(FramePrincipal framePrincipal, FrameOpciones frameOpciones){ 
        super(framePrincipal);
        this.frameOpciones = frameOpciones;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        framePrincipal.setPanel(new PanelBienvenida(framePrincipal));
        framePrincipal.setEnabled(true);
        frameOpciones.dispose();
    }

}
