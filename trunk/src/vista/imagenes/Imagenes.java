package vista.imagenes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Imagenes {
    CUADRA("Imagenes/cuadra.png");
    
    private String ruta;
    
    private Imagenes(String ruta){
        this.ruta = ruta;
    }
    
    public BufferedImage obtenerImagen(){
        BufferedImage imagen = null;
        try {                
            imagen = ImageIO.read(new File(ruta));
         } catch (IOException ex) {
             ex.printStackTrace();
         }
        return imagen;
    }
    
}
