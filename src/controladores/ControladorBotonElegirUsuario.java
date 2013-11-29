package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.juego.Juego;
import vista.componentes.FramePrincipal;
import vista.componentes.PanelComenzarPartida;

public class ControladorBotonElegirUsuario implements ActionListener {
    
    String nombre;
    FramePrincipal framePrincipal;
    
    public ControladorBotonElegirUsuario(FramePrincipal framePrincipal, String nombreElegido){
        this.nombre = nombreElegido;
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(nombre != null && !nombre.isEmpty()) {
            Juego juego = Juego.getInstance();
            juego.getJugador().setNombre(nombre);
        }
        framePrincipal.setPanel(new PanelComenzarPartida(framePrincipal));
    }
}
