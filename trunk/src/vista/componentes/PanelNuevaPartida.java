package vista.componentes;

import java.awt.event.ActionListener;

import vista.componentes.PanelCentrado;
import vista.imagenes.Imagenes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import controladores.ControladorRadioBotonDificultad;
import controladores.ControladorRadioBotonVehiculo;
import controladores.ControladorBotonJugar;

public class PanelNuevaPartida extends PanelCentrado {

    private static final long serialVersionUID = 1L;
    
    public PanelNuevaPartida(FramePrincipal framePrincipal){
        super(framePrincipal);
    }
    
    @Override
    protected void configurarComponentes(){
        
        this.add(crearLabel("Nueva Partida"));
        this.insertarGapVertical(50);
        
        this.add(crearLabel("Elegir dificultad:"));
        this.insertarGapVertical(10);
        crearBotonesDeDificultad();
        
        this.insertarGapVertical(30);
        this.add(crearLabel("Elegir vehiculo:"));
        this.insertarGapVertical(10);
        crearBotonesDeVehiculo();
        
        this.insertarGapVertical(30);
        this.add(crearBotonJugar());
        
    }
    
    private JLabel crearLabel(String texto){
        JLabel label = new JLabel(texto);
        centrarComponenteEnX(label);
        return label;
    }
    
    private void crearBotonesDeDificultad() {
        ButtonGroup grupo = new ButtonGroup();
        JRadioButton botonFacil= crearRadioBotonFacil();
        JRadioButton botonModerado= crearRadioBotonModerado();
        JRadioButton botonDificil= crearRadioBotonDificil();
        grupo.add(botonFacil);
        grupo.add(botonModerado);
        grupo.add(botonDificil);
        this.add(botonFacil);
        this.add(botonModerado);
        this.add(botonDificil);
    }
    
    private void crearBotonesDeVehiculo() {
        ButtonGroup grupo = new ButtonGroup();
        JRadioButton botonAuto= crearRadioBotonAuto();
        JRadioButton botonCuatroXCuatro= crearRadioBotonCuatroXCuatro();
        JRadioButton botonMoto= crearRadioBotonMoto();
        grupo.add(botonAuto);
        grupo.add(botonCuatroXCuatro);
        grupo.add(botonMoto);
        this.add(botonAuto);
        this.add(botonCuatroXCuatro);
        this.add(botonMoto);
    }
    
    
    private JRadioButton crearRadioBotonFacil(){
        JRadioButton boton = new JRadioButton("Facil");
        centrarComponenteEnX(boton);
        boton.addActionListener(crearControladorRadioBotonDificultad(0));
        return boton;
    }
    
    private JRadioButton crearRadioBotonModerado(){
        JRadioButton boton = new JRadioButton("Moderado");
        centrarComponenteEnX(boton);
        boton.addActionListener(crearControladorRadioBotonDificultad(1));
        boton.setSelected(true);
        return boton;
    }
    
    private JRadioButton crearRadioBotonDificil(){
        JRadioButton boton = new JRadioButton("Dificil");
        centrarComponenteEnX(boton);
        boton.addActionListener(crearControladorRadioBotonDificultad(2));
        return boton;
    }
    
    private JRadioButton crearRadioBotonAuto(){
        JRadioButton boton = new JRadioButton("Automovil");
        centrarComponenteEnX(boton);
        boton.addActionListener(crearControladorRadioBotonVehiculo(0));
        boton.setSelected(true);
        boton.setIcon(new ImageIcon(Imagenes.imagenEnRuta("Imagenes/Automovil.png")));
        return boton;
    }
    
    private JRadioButton crearRadioBotonCuatroXCuatro(){
        JRadioButton boton = new JRadioButton("Cuatro X Cuatro");
        centrarComponenteEnX(boton);
        boton.addActionListener(crearControladorRadioBotonVehiculo(1));
        boton.setIcon(new ImageIcon(Imagenes.imagenEnRuta("Imagenes/CuatroXCuatro.png")));
        return boton;
    }
    
    private JRadioButton crearRadioBotonMoto(){
        JRadioButton boton = new JRadioButton("Moto");
        centrarComponenteEnX(boton);
        boton.addActionListener(crearControladorRadioBotonVehiculo(2));
        boton.setIcon(new ImageIcon(Imagenes.imagenEnRuta("Imagenes/Moto.png")));
        return boton;
    }
    
    private ActionListener crearControladorRadioBotonDificultad(int dificultad){
        ActionListener listener = new ControladorRadioBotonDificultad(dificultad);
        return listener;
    }
    
    private ActionListener crearControladorRadioBotonVehiculo(int dificultad){
        ActionListener listener = new ControladorRadioBotonVehiculo(dificultad);
        return listener;
    }
    
    private JButton crearBotonJugar(){
        JButton boton = new JButton("Jugar");
        boton.addActionListener(crearControladorJugar());
        centrarComponenteEnX(boton);
        return boton;
    }
    
    private ControladorBotonJugar crearControladorJugar(){
        return new ControladorBotonJugar(framePrincipal);
    }
    
}