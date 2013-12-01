package vista.componentes;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FrameOpciones extends FramePrincipal {

    private static final long serialVersionUID = 1L;

    public FrameOpciones(){
        setDimension(new Dimension(200,300));
        configurarPropiedades();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
