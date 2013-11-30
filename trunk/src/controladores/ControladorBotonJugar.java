package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import modelo.general.Mapa;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.persistencia.FachadaPersistencia;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelMapa;

public class ControladorBotonJugar implements ActionListener {

    FramePrincipal framePrincipal;
    
    public ControladorBotonJugar(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        cargarMapa();
        generarPosiciones();
        //framePrincipal.setPanel(new PanelMapa(framePrincipal));
        JPanel panel = new PanelMapa(framePrincipal); 
        framePrincipal.setPanel(panel); 
        panel.requestFocus();
    }
    
    private void cargarMapa(){
        FachadaPersistencia persistencia = new FachadaPersistencia();
        Juego.Dificultad dificultad = Juego.getInstance().getDificultad();
        persistencia.cargarMapa(dificultad.getArchivoDelMapa());
    }
    
    private void generarPosiciones(){
        generarMeta();
        generarPosicionInicial();        
    }
    
    private void generarMeta(){
        Mapa.getInstance().generarMeta();
    }
    
    private void generarPosicionInicial(){
        Jugador jugador = Juego.getInstance().getJugador();
        jugador.generarPosicion();
    }
    
}