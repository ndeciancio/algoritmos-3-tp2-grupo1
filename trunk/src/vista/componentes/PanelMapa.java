package vista.componentes;

import java.awt.image. BufferedImage;
import vista.imagenes.Imagenes;
import modelo.general.Mapa;

import java.awt.Graphics;

public class PanelMapa extends PanelCentrado {

    private static final long serialVersionUID = 1L;
    
    private final int DISTANCIA_ENTRE_CUADRAS = 40; // px
    private int cuadrasEnX;
    private int cuadrasEnY;
    
    public PanelMapa(FramePrincipal framePrincipal) {
       super(framePrincipal);
       configurarMapa();
    }
    
    private void configurarMapa(){
        Mapa mapa = Mapa.getInstance();
        this.cuadrasEnX = mapa.getAncho() + 1;
        this.cuadrasEnY = mapa.getAlto() + 1;
    }

    @Override
    protected void paintComponent(Graphics grafico) {
        super.paintComponent(grafico);
        pintarCuadras(grafico);
    }
    
    private void pintarCuadras(Graphics grafico){
        int auxEnX=0;
        int auxEnY=0;
        BufferedImage imagenCuadra = Imagenes.CUADRA.obtenerImagen();
        for (int i=0; i < cuadrasEnX; i++) {
            for (int j=0; j < cuadrasEnY; j++) {
                grafico.drawImage(imagenCuadra, auxEnX, auxEnY+DISTANCIA_ENTRE_CUADRAS, null);
                auxEnY=auxEnY+DISTANCIA_ENTRE_CUADRAS;
            }
            auxEnX=auxEnX+DISTANCIA_ENTRE_CUADRAS;
            auxEnY=0;
        }
    }
    
}