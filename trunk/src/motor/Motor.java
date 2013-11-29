package motor;

import modelo.juego.Juego;
import modelo.juego.Jugador;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelBienvenida;
import vista.componentes.PanelMapa;
import vista.componentes.PanelGanaste;
import vista.componentes.PanelElegirUsuario;
import vista.componentes.PanelPerdiste;
import vista.componentes.PanelPuntajes;
import vista.componentes.PanelNuevaPartida;
import vista.componentes.PanelComenzarPartida;

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
		//ventanaPrincipal.setPanel(new PanelBienvenida(ventanaPrincipal));
		ventanaPrincipal.setPanel(new PanelBienvenida(ventanaPrincipal));
		ventanaPrincipal.mostrar();
	}
	
}
