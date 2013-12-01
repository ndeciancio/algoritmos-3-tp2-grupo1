package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;

import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.persistencia.FachadaPersistencia;

public class ControladorBotonGuardarPartida implements ActionListener {
    FramePrincipal framePrincipal;
    Jugador jugador;

    public ControladorBotonGuardarPartida(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
        this.jugador = Juego.getInstance().getJugador();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        FachadaPersistencia persistencia = new FachadaPersistencia();
        persistencia.guardarPartida(jugador.getNombre());
        this.framePrincipal.getContentPane().requestFocus();
    }
    
}