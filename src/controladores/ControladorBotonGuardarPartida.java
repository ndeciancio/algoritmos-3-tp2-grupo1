package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelMapa;

import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.persistencia.FachadaPersistencia;

public class ControladorBotonGuardarPartida implements ActionListener {
    PanelMapa panelMapa;
    Jugador jugador;

    public ControladorBotonGuardarPartida(PanelMapa panelMapa){
        this.panelMapa = panelMapa;
        this.jugador = Juego.getInstance().getJugador();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        FachadaPersistencia persistencia = new FachadaPersistencia();
        persistencia.guardarPartida(jugador.getNombre());
        this.panelMapa.requestFocus();
    }
    
}