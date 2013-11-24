package vista.componentes;

import javax.swing.JPanel;
import java.awt.image. BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.io.IOException;

public class PanelMapa extends JPanel{

    private BufferedImage image;
    protected FramePrincipal framePrincipal;
    
    private Integer DistanciaEntreCuadras = 50;
    private Integer CuadrasEnX = 7;
    private Integer CuadrasEnY = 3; //numeros para probar, despues se las asigna con un set
    
    public PanelMapa(FramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
       try {                
          image = ImageIO.read(new File("Imagenes/cuadra.png"));
       } catch (IOException ex) {
           System.out.println("No encontro la imagen");
           // excepcion si no encuentra la imagen
       }
    }

    @Override
    protected void paintComponent(Graphics grafico) {
        int auxEnX=0;
        int auxEnY=0;
        super.paintComponent(grafico);
        for (int i=0; i<CuadrasEnX; i++) {
            for (int j=0; j<CuadrasEnY; j++) {
                grafico.drawImage(image, auxEnX, auxEnY+DistanciaEntreCuadras, null);
                auxEnY=auxEnY+DistanciaEntreCuadras;
            }
            auxEnX=auxEnX+DistanciaEntreCuadras;
            auxEnY=0;
        }
    }
}