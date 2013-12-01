package vista.componentes;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

import controladores.ControladorBotonGuardarPartida;
import controladores.ControladorBotonIrAPanelBienvenida;

public class FrameOpciones extends JFrame {

    private static final long serialVersionUID = 1L;

    private final String TITULO = "Opciones";
    private Dimension DIMENSIONES = new Dimension(200, 100);
    
    FramePrincipal framePrincipal;
    
    public FrameOpciones(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
        configurarLayout();
        configurarPropiedades();
        configurarComponentes();
    }
    
    private void configurarLayout(){
        setLayout(new FlowLayout());
    }
    
    private void configurarPropiedades(){
        setTitle(TITULO);
        setSize(DIMENSIONES);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void configurarComponentes(){
        this.add(crearBotonGuardar());
        this.add(crearBotonVolverAPanelBienvenida());
    }
    
    private JButton crearBotonGuardar(){
        JButton boton = new JButton("Guardar Partida");
        boton.addActionListener(new ControladorBotonGuardarPartida(framePrincipal));
        return boton;
    }
    
    private JButton crearBotonVolverAPanelBienvenida(){
        JButton boton = new JButton("Retirarse");
        boton.addActionListener(new ControladorBotonIrAPanelBienvenida(framePrincipal));
        return boton;
    }
    
    public void mostrar(){
        setVisible(true);
    }
}
