package vista.componentes;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class PanelCentrado extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelCentrado(){
        configurarLayout();
        crearPegamentoVertical();
        configurarComponentes();
        crearPegamentoVertical();
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

}
