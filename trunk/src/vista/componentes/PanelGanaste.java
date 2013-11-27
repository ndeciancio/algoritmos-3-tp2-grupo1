package vista.componentes;

import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.juego.Juego;
import controladores.ControladorBotonJugarOtraVez;


public class PanelGanaste extends PanelCentrado {

    private static final long serialVersionUID = 1L;
    
    public PanelGanaste(FramePrincipal framePrincipal){
        super(framePrincipal);
    }
    
    protected void configurarComponentes(){
        this.add(crearLabelGanaste());
        this.add(crearLabelMovimientosRestantes());
        this.add(crearLabelPuntaje());
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
    
    private JLabel crearLabelGanaste(){
        JLabel label = new JLabel("Ganaste!");
        centrarComponenteEnX(label);
        return label;
    }
    
    private JLabel crearLabelDificultad(){
        int movimientos =Juego.getInstance().getDificultad().getLimiteDeMovimientos() - Juego.getInstance().getJugador().getMovimientos();
        String texto = "Te sobraron " + Integer.toString(movimientos) + " movimientos";
        JLabel label = new JLabel(texto);
        centrarComponenteEnX(label);
        return label;
    }
    
    private JLabel crearLabelMovimientosRestantes(){
        int movimientos =Juego.getInstance().getDificultad().getLimiteDeMovimientos() - Juego.getInstance().getJugador().getMovimientos();
        String texto = "Te sobraron " + Integer.toString(movimientos) + " movimientos";
        JLabel label = new JLabel(texto);
        centrarComponenteEnX(label);
        return label;
    }
    
    private JLabel crearLabelPuntaje(){
        int puntaje =Juego.getInstance().getDificultad().calcularPuntuacion(Juego.getInstance().getJugador().getMovimientos());
        String texto = "Obtuviste un puntaje de: " + Integer.toString(puntaje) + " puntos";
        JLabel label = new JLabel(texto);
        centrarComponenteEnX(label);
        return label;
    }
    
    
    
    
    
}
