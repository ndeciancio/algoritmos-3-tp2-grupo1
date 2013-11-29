package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.persistencia.FachadaPersistencia;

public class ControladorBotonElegirUsuario implements ActionListener {
    
    String nombre;
    JFrame framePrincipal;
    
    public ControladorBotonElegirUsuario(JFrame framePrincipal, String nombreElegido){
        this.nombre = nombreElegido;
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(nombre != null && !nombre.isEmpty()) {
            Juego juego = Juego.getInstance();
            juego.getJugador().setNombre(nombre);
        }
    }
    
    public void actualizar(String nombreElegido) {
        this.nombre = nombreElegido;
    }
}
