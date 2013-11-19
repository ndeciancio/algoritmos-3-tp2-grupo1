package vista.componentes;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private final Dimension DIMENSIONES = new Dimension(800, 600);
	
	public FramePrincipal(){
		this.setSize(DIMENSIONES);
		this.setVisible(true);
	}

}
