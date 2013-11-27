package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.componentes.FramePrincipal;
import modelo.juego.Juego;
import modelo.juego.Jugador;

public class ControladorBotonMoverDerecha implements ActionListener {
    
    JFrame framePrincipal;

    public ControladorBotonMoverDerecha(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        Juego juego = Juego.getInstance();
        Jugador jugador = juego.getJugador();
        jugador.moverDerecha();
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
    
}
