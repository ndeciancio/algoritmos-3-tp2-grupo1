package modelo.persistencia;

import java.io.File;
import java.io.IOException;

public class ArchivoPuntuaciones extends File {

    private static final long serialVersionUID = 1L;
    private static final String RUTA_ARCHIVO_PUNTUACIONES = "data/puntuaciones.xml";
    
    public ArchivoPuntuaciones() throws IOException {
        super(RUTA_ARCHIVO_PUNTUACIONES);
        this.createNewFile();
    }

}
