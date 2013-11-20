package vista.componentes;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private final String TITULO = "GPS Challenge";
	private final Dimension DIMENSIONES = new Dimension(480, 320);
	
	public FramePrincipal(JPanel panelInicial){
		configurarPropiedades();
		setPanel(panelInicial);
		mostrar();
	}
	
	private void configurarPropiedades(){
		this.setTitle(TITULO);
		this.setSize(DIMENSIONES);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanel(JPanel panel){
		this.setContentPane(panel);
		this.revalidate();
		this.repaint();
	}
	
	private void mostrar(){
		this.setVisible(true);
	}

}
