package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.persistencia.FachadaPersistencia;

public class ControladorBotonGuardarNuevoJugador implements ActionListener {
    
    JTextField campoDeTextoConElNombre;
    JFrame framePrincipal;
    
    public ControladorBotonGuardarNuevoJugador(JFrame framePrincipal, JTextField campoDeTexto){
        this.campoDeTextoConElNombre = campoDeTexto;
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        Juego juego = Juego.getInstance();
        juego.getJugador().setNombre(campoDeTextoConElNombre.getText());
        guardarNuevoJugadorConPuntuacionCero(juego.getJugador());
    }

    private void guardarNuevoJugadorConPuntuacionCero(Jugador jugador){
        FachadaPersistencia persistencia = new FachadaPersistencia();
        persistencia.nuevaPuntuacion(jugador.getNombre(), 0);
        // Actualizar la escena en el framePrincipal.
    }
}
