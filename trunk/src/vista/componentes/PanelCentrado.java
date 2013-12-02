package vista.componentes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import vista.imagenes.Imagenes;

public abstract class PanelCentrado extends JPanel {

    private static final long serialVersionUID = 1L;
    protected FramePrincipal framePrincipal;
    private BufferedImage fondo;
    
    public PanelCentrado(FramePrincipal framePrincipal){
        this.framePrincipal = framePrincipal;
        configurarLayout();
        crearPegamentoVertical();
        configurarComponentes();
        crearPegamentoVertical();
        fondo = Imagenes.imagenEnRuta("Imagenes/BienvenidaGps.png");
    }
    
    @Override
    protected void paintComponent(Graphics grafico) {
        pintarFondo(grafico);
    }
    
    protected void configurarLayout(){
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
    
    // Template Method
    protected void configurarComponentes(){
    }
    
    protected void insertarGapVertical(int pixeles){
        this.add(Box.createRigidArea(new Dimension(0, pixeles)));
    }
    
    protected void centrarComponenteEnX(JComponent component){
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    private void crearPegamentoVertical(){
        this.add(Box.createVerticalGlue());
    }
    
    private void pintarFondo(Graphics grafico){
        grafico.drawImage(this.fondo, 0, 0, this);
    }
    
}
