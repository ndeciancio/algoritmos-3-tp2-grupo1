package motor;

import modelo.juego.Juego;
import modelo.juego.Jugador;

import vista.componentes.FramePrincipal;
import vista.componentes.PanelBienvenida;
import vista.componentes.PanelMapa;

public class Motor {

	private static FramePrincipal ventanaPrincipal;
	
	public static void main(String[] args){
	    inicializarJuegoConOpcionesPorDefecto();
		inicializarGUI();
	}
	
	public static void inicializarJuegoConOpcionesPorDefecto(){
	    Juego juego = Juego.getInstance();
	    juego.setJugador(Jugador.crearPorDefecto());
	    juego.setDificultad(Juego.Dificultad.MODERADO);
	}
	
	public static void inicializarGUI(){
		ventanaPrincipal = new FramePrincipal();
		ventanaPrincipal.setPanel(new PanelMapa(ventanaPrincipal));
		ventanaPrincipal.mostrar();
	}
	
}
