package vista.imagenes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Imagenes {
    CUADRA("Imagenes/cuadra.png"),
    AUTOMOVIL("Imagenes/automovil.png"),
    MOTO("Imagenes/moto.png"),
    CUATRO_X_CUATRO("Imagenes/cuatroporcuatro.png");
    
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
