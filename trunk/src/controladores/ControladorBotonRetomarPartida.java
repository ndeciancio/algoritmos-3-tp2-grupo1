package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.persistencia.FachadaPersistencia;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelMapa;

public class ControladorBotonRetomarPartida implements ActionListener {

    FramePrincipal framePrincipal;
    Jugador jugador;
    
    public ControladorBotonRetomarPartida(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
        this.jugador = Juego.getInstance().getJugador();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        cargarPartida();
        framePrincipal.setPanel(new PanelMapa(framePrincipal));
        this.framePrincipal.getContentPane().requestFocus();
    }
    
    private void cargarPartida(){
        FachadaPersistencia persistencia = new FachadaPersistencia();
        persistencia.cargarPartida(jugador.getNombre());
    }
    
}
