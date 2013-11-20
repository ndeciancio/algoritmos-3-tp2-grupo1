package vista.componentes;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelIngresarNombre extends PanelCentrado {

    private static final long serialVersionUID = 1L;

    @Override
    protected void configurarComponentes(){
        
        this.add(crearLabelIngreseSuNombre());
        
        this.insertarGapVertical(10);
        this.add(crearCampoDeTextoNombre());
        
        this.insertarGapVertical(10);
        this.add(crearBotonAceptar());
        
    }
    
    private JLabel crearLabelIngreseSuNombre(){
        JLabel label = new JLabel("Por favor, elija un nombre...");
        centrarComponenteEnX(label);
        return label;
    }
    
    private JTextField crearCampoDeTextoNombre(){
        JTextField text = new JTextField();
        text.setPreferredSize(new Dimension(200, 25));
        text.setMaximumSize(text.getPreferredSize());
        centrarComponenteEnX(text);
        return text;
    }
    
    private JButton crearBotonAceptar(){
        JButton boton = new JButton("Aceptar");
        centrarComponenteEnX(boton);
        return boton;
    }
    
}
