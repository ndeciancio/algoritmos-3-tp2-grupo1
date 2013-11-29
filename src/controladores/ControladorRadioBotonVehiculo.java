package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.moviles.Automovil;
import modelo.moviles.CuatroXCuatro;
import modelo.moviles.Moto;
import modelo.juego.Juego;

public class ControladorRadioBotonVehiculo implements ActionListener {
    int vehiculo;
    
    public ControladorRadioBotonVehiculo(int i){
        vehiculo = i;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vehiculo==0) {
            Juego juego = Juego.getInstance();
            Automovil unAuto = new Automovil();
            juego.getJugador().setMovil(unAuto);
        }
        else if (vehiculo==1) {
            Juego juego = Juego.getInstance();
            CuatroXCuatro unaCuatroXCuatro = new CuatroXCuatro();;
            juego.getJugador().setMovil(unaCuatroXCuatro);
        }
        else if (vehiculo==2) {
            Juego juego = Juego.getInstance();
            Moto unaMoto = new Moto();
            juego.getJugador().setMovil(unaMoto);
        }
    }

}