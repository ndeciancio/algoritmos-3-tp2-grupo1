package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import vista.componentes.PanelMapa;
import vista.componentes.FramePrincipal;
import vista.componentes.PanelComenzarPartida;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.persistencia.FachadaPersistencia;

public class ControladorBotonGuardarNuevoJugador implements ActionListener {
    
    JTextField campoDeTextoConElNombre;
    FramePrincipal framePrincipal;
    
    public ControladorBotonGuardarNuevoJugador(FramePrincipal framePrincipal, JTextField campoDeTexto){
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
        framePrincipal.setPanel(new PanelComenzarPartida(framePrincipal));
    }
}
