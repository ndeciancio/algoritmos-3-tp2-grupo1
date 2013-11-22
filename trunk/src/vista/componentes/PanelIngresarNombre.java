package vista.componentes;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controladores.ControladorBotonGuardarNuevoJugador;

public class PanelIngresarNombre extends PanelCentrado {

    private static final long serialVersionUID = 1L;
    
    public PanelIngresarNombre(FramePrincipal framePrincipal){
        super(framePrincipal);
    }
    
    @Override
    protected void configurarComponentes(){
        
        this.add(crearLabelIngreseSuNombre());
        
        JTextField campoDeTexto = crearCampoDeTextoNombre();
        this.insertarGapVertical(10); 
        this.add(campoDeTexto);
        
        JButton botonAceptar = crearBotonAceptar();
        botonAceptar.addActionListener(crearControladorAceptar(campoDeTexto));
        this.insertarGapVertical(10);
        this.add(botonAceptar);
        
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
    
    private ActionListener crearControladorAceptar(JTextField campoConNombre){
        ActionListener listener = new ControladorBotonGuardarNuevoJugador(framePrincipal, campoConNombre);
        return listener;
    }
    
}
