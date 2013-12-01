package vista.componentes;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
        setResizable(false);
        setLocationRelativeTo(framePrincipal);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        framePrincipal.enable(false);
        final FrameOpciones frameOpciones = this;
        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                frameOpciones.setVisible(false);
                framePrincipal.enable(true);
                
            }
        };
        addWindowListener(exitListener);
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
