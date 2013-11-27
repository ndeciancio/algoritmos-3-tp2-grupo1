package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import modelo.juego.Juego;
import modelo.general.Mapa;
import vista.componentes.PanelMapa;

public class ControladorBotonJugarOtraVez implements ActionListener {
    
    FramePrincipal framePrincipal;

    public ControladorBotonJugarOtraVez(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        Juego.getInstance().reiniciar();
        Mapa.getInstance().ponerPorDefecto();
        framePrincipal.setPanel(new PanelMapa(framePrincipal));
    }
    
}