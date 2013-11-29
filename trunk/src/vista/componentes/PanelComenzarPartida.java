package vista.componentes;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.juego.Juego;
import modelo.juego.Jugador;

import controladores.ControladorBotonComenzarPartida;
import controladores.ControladorBotonRetomarPartida;
import controladores.ControladorBotonVerPuntajes;


public class PanelComenzarPartida extends PanelCentrado {

    private static final long serialVersionUID = 1L;
    
    public PanelComenzarPartida(FramePrincipal framePrincipal){
        super(framePrincipal);
    }
    
    @Override
    protected void configurarComponentes(){
        
        this.add(crearLabelComenzarPartida());
        
        this.insertarGapVertical(50);
        this.add(crearBotonComenzarPartida());
        
        this.insertarGapVertical(10);
        this.add(crearBotonRetomarPartida());
        
        this.insertarGapVertical(10);
        this.add(crearBotonVerPuntajes());
        
    }
    
    private JLabel crearLabelComenzarPartida(){
        JLabel label = new JLabel("GPS Challengue");
        centrarComponenteEnX(label);
        return label;
    }
    
    private JButton crearBotonComenzarPartida(){
        JButton boton = new JButton("Comenzar Partida");
        boton.addActionListener(crearControladorComenzarPartida());
        centrarComponenteEnX(boton);
        return boton;
    }
    
    private JButton crearBotonRetomarPartida(){
        JButton boton = new JButton("Retomar Partida Guardada");
        verificarPartidaGuardada(boton);
        boton.addActionListener(crearControladorRetomarPartida());
        centrarComponenteEnX(boton);
        return boton;
    }
    
    private void verificarPartidaGuardada(JButton botonJugar){
        File archivoPartida = new File(partidaDelJugador());
        if(!archivoPartida.exists())
            botonJugar.setEnabled(false);
    }
    
    private String partidaDelJugador(){
        Jugador jugador = Juego.getInstance().getJugador();
        return "data/" + jugador.getNombre() + ".xml";
    }
    
    private JButton crearBotonVerPuntajes(){
        JButton boton = new JButton("Ver Puntajes");
        boton.addActionListener(crearControladorVerPuntajes());
        centrarComponenteEnX(boton);
        return boton;
    }
    
    private ControladorBotonRetomarPartida crearControladorRetomarPartida(){
        return new ControladorBotonRetomarPartida(framePrincipal);
    }
    
    private ControladorBotonComenzarPartida crearControladorComenzarPartida(){
        return new ControladorBotonComenzarPartida(framePrincipal);
    }
    
    private ControladorBotonVerPuntajes crearControladorVerPuntajes(){
        return new ControladorBotonVerPuntajes(framePrincipal);
    }
    
}