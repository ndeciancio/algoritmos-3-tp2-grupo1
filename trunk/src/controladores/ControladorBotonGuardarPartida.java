package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.persistencia.FachadaPersistencia;

public class ControladorBotonGuardarPartida implements ActionListener {
    Jugador jugador;

    public ControladorBotonGuardarPartida(){
        this.jugador = Juego.getInstance().getJugador();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        FachadaPersistencia persistencia = new FachadaPersistencia();
        persistencia.guardarPartida(jugador.getNombre());
    }
    
}