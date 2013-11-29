package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.juego.Juego;

public class ControladorRadioBotonDificultad implements ActionListener {
    int dificultad;
    
    public ControladorRadioBotonDificultad(int i){
        dificultad = i;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (dificultad==0) {
            Juego juego = Juego.getInstance();
            juego.setDificultad(Juego.Dificultad.FACIL);
        }
        else if (dificultad==1) {
            Juego juego = Juego.getInstance();
            juego.setDificultad(Juego.Dificultad.MODERADO);
        }
        else if (dificultad==2) {
            Juego juego = Juego.getInstance();
            juego.setDificultad(Juego.Dificultad.DIFICIL);
        }
    }

}