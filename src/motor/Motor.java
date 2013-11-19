package motor;

import javax.swing.JFrame;

import vista.componentes.FramePrincipal;

public class Motor {

	public static JFrame ventanaPrincipal;
	
	public static void main(String[] args){
		inicializarGUI();
	}
	
	public static void inicializarGUI(){
		ventanaPrincipal = new FramePrincipal();
	}
	
}
