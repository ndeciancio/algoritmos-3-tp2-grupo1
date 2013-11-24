package vista.imagenes;

import java.awt.image.BufferedImage;
import modelo.moviles.Automovil;
import modelo.moviles.CuatroXCuatro;
import modelo.moviles.Moto;

// Permite implementar un double dispatch para que los
// eventos y vehiculos no deban conocer su propia representacion
// en forma de imagen.

public class DespachadorDeImagenes {
    
    public BufferedImage imagenDeMovil(Automovil movil){
        return Imagenes.AUTOMOVIL.obtenerImagen();
    }
    
    public BufferedImage imagenDeMovil(Moto movil){
        return Imagenes.MOTO.obtenerImagen();
    }
    
    public BufferedImage imagenDeMovil(CuatroXCuatro movil){
        return Imagenes.CUATRO_X_CUATRO.obtenerImagen();
    }

}
