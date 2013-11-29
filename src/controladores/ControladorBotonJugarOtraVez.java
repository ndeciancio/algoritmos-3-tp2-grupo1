package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelBienvenida;
import modelo.juego.Juego;
import modelo.general.Mapa;

public class ControladorBotonJugarOtraVez implements ActionListener {
    
    FramePrincipal framePrincipal;

    public ControladorBotonJugarOtraVez(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        Juego.getInstance().ponerPorDefecto();
        Mapa.getInstance().ponerPorDefecto();
        framePrincipal.setPanel(new PanelBienvenida(framePrincipal));
    }
    
}