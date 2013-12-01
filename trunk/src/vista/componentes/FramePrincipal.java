package vista.componentes;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private final String TITULO = "GPS Challenge";
	private Dimension DIMENSIONES = new Dimension(800, 600);
	
	public FramePrincipal(){
		configurarPropiedades();
	}
	
    public void setPanel(JPanel panel){
        this.setContentPane(panel);
        this.actualizar();
    }
    
    public void actualizar(){
        this.revalidate();
        this.repaint();
    }
    
    public void mostrar(){
        this.setVisible(true);
    }
	
	protected void configurarPropiedades(){
		this.setTitle(TITULO);
		this.setSize(DIMENSIONES);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setDimension(Dimension dimension){
	    this.DIMENSIONES = dimension;
	}

}
