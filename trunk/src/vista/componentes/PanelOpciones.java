package vista.componentes;

import javax.swing.JButton;

import controladores.ControladorBotonGuardarPartida;
import controladores.ControladorBotonIrAPanelBienvenida;

public class PanelOpciones extends PanelCentrado {

    private static final long serialVersionUID = 1L;
    PanelMapa panelMapa;
    
    public PanelOpciones(FrameOpciones frameOpciones) {
        super(frameOpciones);       
    }
    
    public void setPanelMapa(PanelMapa panelMapa){
        this.panelMapa = panelMapa;
    }

    private JButton crearBotonGuardar(){
        JButton boton = new JButton("Guardar Partida");
        boton.addActionListener(new ControladorBotonGuardarPartida(this.panelMapa));
        boton.setBounds(15, 130, 150, 25);
        return boton;
    }
    
    private JButton crearBotonVolverAPanelBienvenida(){
        JButton boton = new JButton("Retirarse");
        boton.addActionListener(new ControladorBotonIrAPanelBienvenida(this.panelMapa.getFramePrincipal()));
        boton.setBounds(15, 170, 150, 25);
        return boton;
    }
    
    @Override
    protected void configurarComponentes(){
        this.add(crearBotonGuardar());
        this.add(crearBotonVolverAPanelBienvenida());
    }
}
