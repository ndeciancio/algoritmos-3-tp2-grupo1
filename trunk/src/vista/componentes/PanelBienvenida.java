package vista.componentes;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelBienvenida extends PanelCentrado {

	private static final long serialVersionUID = 1L;
	
	public PanelBienvenida(){
	    super();
	}
	
	@Override
	protected void configurarComponentes(){
	    
		this.add(crearLabelBienvenido());
		
		this.insertarGapVertical(10);
		this.add(crearBotonSoyNuevo());
		
		this.insertarGapVertical(10);
		this.add(crearBotonTengoUsuario());
	}
	
	private JLabel crearLabelBienvenido(){
	    JLabel label = new JLabel("Bienvenido");
	    centrarComponenteEnX(label);
	    return label;
	}
	
	private JButton crearBotonSoyNuevo(){
	    JButton boton = new JButton("Soy Nuevo");
	    centrarComponenteEnX(boton);
	    return boton;
	}
	
	private JButton crearBotonTengoUsuario(){
	    JButton boton = new JButton("Ya Tengo Usuario");
	    centrarComponenteEnX(boton);
	    return boton;
	}
	
}
