package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBotonSalir implements ActionListener {

    
    public ControladorBotonSalir(){
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        System.exit(0);
    }
    
}