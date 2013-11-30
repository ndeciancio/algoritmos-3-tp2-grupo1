package vista.componentes;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelo.persistencia.FachadaPersistencia;
import modelo.persistencia.TablaDePuntuaciones;
import modelo.persistencia.TablaDePuntuaciones.Entrada;
import controladores.ControladorBotonGuardarNuevoJugador;
import controladores.ControladorBotonJugarOtraVez;
import controladores.ControladorBotonPanelComenzarPartida;

public class PanelPuntajes extends PanelCentrado {

    private static final long serialVersionUID = 1L;
    
    public PanelPuntajes(FramePrincipal framePrincipal){
        super(framePrincipal);
    }
    
    @Override
    protected void configurarComponentes(){
        
        this.add(crearLabelPuntajes());
        this.insertarGapVertical(10);
        crearLabelsDePuntajes();
        this.insertarGapVertical(20);
        this.add(crearBotonVolverAPanelComenzarPartida());
    }
    
    private JLabel crearLabelPuntajes(){
        JLabel label = new JLabel("Puntajes:");
        centrarComponenteEnX(label);
        return label;
    }
    
    private void crearLabelsDePuntajes() {
        String texto;
        FachadaPersistencia persistencia = new FachadaPersistencia();
        TablaDePuntuaciones tabla = persistencia.cargarPuntuaciones();
        Iterator<Entrada> iterador = tabla.iterator();
        for(Iterator<Entrada> i=iterador; i.hasNext(); ) {
            Entrada entrada = i.next();
            texto= entrada.getNombre() + "            " + Integer.toString(entrada.getPuntuacion());
            JLabel label = new JLabel (texto);
            this.add(label);
            centrarComponenteEnX(label);
        }
    }
    
    private JButton crearBotonVolverAPanelComenzarPartida(){
        JButton boton = new JButton("Volver");
        boton.addActionListener(crearControladorVolverAPanelComenzarPartida());
        centrarComponenteEnX(boton);
        return boton;
    }
    
    private ControladorBotonPanelComenzarPartida crearControladorVolverAPanelComenzarPartida(){
        return new ControladorBotonPanelComenzarPartida(framePrincipal);
    }
    
}