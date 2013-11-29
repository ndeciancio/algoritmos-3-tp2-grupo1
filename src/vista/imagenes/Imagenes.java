package vista.imagenes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Imagenes {
    CUADRA("Imagenes/cuadra.png"),
    AUTOMOVIL("Imagenes/Automovil.png"),
    MOTO("Imagenes/Moto.png"),
    CUATRO_X_CUATRO("Imagenes/CuatroXCuatro.png"),
    AREA_INVISIBLE("Imagenes/AreaInvisible.png");
    
    private String ruta;
    
    private Imagenes(String ruta){
        this.ruta = ruta;
    }
    
    public BufferedImage obtenerImagen(){
        return Imagenes.imagenEnRuta(ruta);
    }
    
    public static BufferedImage pngDesdeObjeto(Object objeto){
        String ruta = "Imagenes/" + objeto.getClass().getSimpleName() + ".png";
        return Imagenes.imagenEnRuta(ruta);
    }
    
    public static BufferedImage imagenEnRuta(String ruta){
        BufferedImage imagen = null;
        try {                
            imagen = ImageIO.read(new File(ruta));
         } catch (IOException ex) {
             ex.printStackTrace();
         }
        return imagen;
    }
    
}
