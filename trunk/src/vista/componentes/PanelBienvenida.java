package vista.componentes;

import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.juego.Juego;

import controladores.ControladorBotonSoyNuevo;
import controladores.ControladorBotonTengoUsuario;
import controladores.ControladorBotonSalir;

public class PanelBienvenida extends PanelCentrado {

	private static final long serialVersionUID = 1L;
	
	public PanelBienvenida(FramePrincipal framePrincipal){
	    super(framePrincipal);
	    Juego.getInstance().ponerPorDefecto();
	}
	
	@Override
	protected void configurarComponentes(){
	    
		this.add(crearLabelBienvenido());
		
		this.insertarGapVertical(10);
		this.add(crearBotonSoyNuevo());
		
		this.insertarGapVertical(10);
		this.add(crearBotonTengoUsuario());
		
		this.insertarGapVertical(20);
		this.add(crearBotonSalir());
	}
	
	private JLabel crearLabelBienvenido(){
	    JLabel label = new JLabel("Bienvenido");
	    centrarComponenteEnX(label);
	    return label;
	}
	
	private JButton crearBotonSoyNuevo(){
	    JButton boton = new JButton("Soy Nuevo");
	    boton.addActionListener(crearControladorSoyNuevo());
	    centrarComponenteEnX(boton);
	    return boton;
	}
	
	private JButton crearBotonTengoUsuario(){
	    JButton boton = new JButton("Ya Tengo Usuario");
	    boton.addActionListener(crearControladorTengoUsuario());
	    centrarComponenteEnX(boton);
	    return boton;
	}
	
	private JButton crearBotonSalir(){
        JButton boton = new JButton("Salir");
        boton.addActionListener(crearControladorSalir());
        centrarComponenteEnX(boton);
        return boton;
    }
	
	private ControladorBotonSalir crearControladorSalir(){
	    return new ControladorBotonSalir();
	}
	   
	private ControladorBotonSoyNuevo crearControladorSoyNuevo(){
	    return new ControladorBotonSoyNuevo(framePrincipal);
	}
	
	private ControladorBotonTengoUsuario crearControladorTengoUsuario(){
        return new ControladorBotonTengoUsuario(framePrincipal);
    }
	
}
