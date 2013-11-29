package vista.componentes;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import vista.componentes.PanelCentrado;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import modelo.persistencia.FachadaPersistencia;
import modelo.persistencia.TablaDePuntuaciones;
import modelo.persistencia.TablaDePuntuaciones.Entrada;
import controladores.ControladorBotonElegirUsuario;

public class PanelElegirUsuario extends PanelCentrado {

    private static final long serialVersionUID = 1L;
    private String nombreElegido;
    private JButton botonElegirUsuario;
    
    public PanelElegirUsuario(FramePrincipal framePrincipal){
        super(framePrincipal);
        nombreElegido = "";
    }
    
    public String getNombreElegido(){
        return nombreElegido;
    }
    
    @Override
    protected void configurarComponentes(){
        
        this.add(crearLabelIngreseSuNombre());
        crearBotonesDeUsuario();
        botonElegirUsuario = crearBotonElegirUsuarior();
        this.add(botonElegirUsuario);
        
    }
    
    private JLabel crearLabelIngreseSuNombre(){
        JLabel label = new JLabel("Por favor, elija un nombre...");
        centrarComponenteEnX(label);
        return label;
    }
    
    private void crearBotonesDeUsuario() {
        FachadaPersistencia persistencia = new FachadaPersistencia();
        TablaDePuntuaciones tabla = persistencia.cargarPuntuaciones();
        Iterator<Entrada> iterador = tabla.iterator();
        ButtonGroup grupo = new ButtonGroup();
        for(Iterator<Entrada> i=iterador; i.hasNext(); ) {
            Entrada entrada = i.next();
            JRadioButton boton = crearRadioBotonUsuarioElegido(entrada.getNombre());
            grupo.add(boton);
            this.add(boton);
        }
    }
    
    
    private JRadioButton crearRadioBotonUsuarioElegido(String nombre){
        JRadioButton boton = new JRadioButton(nombre);
        centrarComponenteEnX(boton);
        boton.addActionListener(crearControladorRadioBotonUsuarioElegido(nombre));
        return boton;
    }
    
    private ActionListener crearControladorRadioBotonUsuarioElegido(String nombreBoton){
        ActionListener listener = new ControladorRadioBotonUsuarioElegido(framePrincipal, nombreBoton);
        return listener;
    }
    
    private void actualizarBotonElegirUsuario (){
        for( ActionListener al : botonElegirUsuario.getActionListeners() ) {
            botonElegirUsuario.removeActionListener( al );
        }
        botonElegirUsuario.addActionListener(crearControladorBotonElegirUsuario(nombreElegido));
    }
    
    private JButton crearBotonElegirUsuarior(){
        JButton boton = new JButton("Elegir Usuario");
        centrarComponenteEnX(boton);        
        return boton;
    }
    
    private ActionListener crearControladorBotonElegirUsuario (String nombre) {
        ActionListener listener = new ControladorBotonElegirUsuario(framePrincipal, nombreElegido);
        return listener;
    }
    
    private class ControladorRadioBotonUsuarioElegido implements ActionListener {
        String nombreBoton;
     
        public ControladorRadioBotonUsuarioElegido(JFrame framePrincipal,String nombreBoton){
            this.nombreBoton  = nombreBoton;
        }
        
        @Override
        public void actionPerformed(ActionEvent evento) {
            nombreElegido = nombreBoton;
            actualizarBotonElegirUsuario ();
        }

    }
}