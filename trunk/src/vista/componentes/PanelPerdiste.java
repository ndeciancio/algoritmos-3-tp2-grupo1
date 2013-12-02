package vista.componentes;

import javax.swing.JButton;
import javax.swing.JLabel;

import controladores.ControladorBotonJugarOtraVez;


public class PanelPerdiste extends PanelCentrado {

    private static final long serialVersionUID = 1L;
    
    public PanelPerdiste(FramePrincipal framePrincipal){
        super(framePrincipal);
    }
    
    protected void configurarComponentes(){
        this.add(crearLabelPerdiste());
        this.add(crearBotonJugarOtraVez());
    }

    private ControladorBotonJugarOtraVez crearControladorJugarOtraVez(){
        return new ControladorBotonJugarOtraVez(framePrincipal);
    }
    
    private JButton crearBotonJugarOtraVez(){
        JButton boton = new JButton("Jugar Otra Vez");
        boton.addActionListener(crearControladorJugarOtraVez());
        centrarComponenteEnX(boton);
        return boton;
    }
    
    
    private JLabel crearLabelPerdiste(){
        JLabel label = new JLabel("Perdiste");
        centrarComponenteEnX(label);
        return label;
    }
}
    