package motor;

import modelo.juego.Juego;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelBienvenida;

public class Motor {

	private static FramePrincipal ventanaPrincipal;
	
	public static void main(String[] args){
	    inicializarJuegoConOpcionesPorDefecto();
		inicializarGUI();
	}
	
	public static void inicializarJuegoConOpcionesPorDefecto(){
	    Juego.getInstance().ponerPorDefecto();
	}
	
	public static void inicializarGUI(){
		ventanaPrincipal = new FramePrincipal();
		ventanaPrincipal.setPanel(new PanelBienvenida(ventanaPrincipal));
		ventanaPrincipal.mostrar();
	}
	
}
