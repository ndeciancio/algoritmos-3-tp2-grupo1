package modelo.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class ArchivoPuntuaciones extends File {

    private static final long serialVersionUID = 1L;
    private static final String RUTA_ARCHIVO_PUNTUACIONES = "data/puntuaciones.xml";
    
    public ArchivoPuntuaciones() throws IOException {
        super(RUTA_ARCHIVO_PUNTUACIONES);
        crearArchivoSiNoExisteYa();
    }

    private void crearArchivoSiNoExisteYa() throws IOException{
        if(createNewFile())
            ingresarRootXML();
    }
    
    private void ingresarRootXML() throws IOException {
        PrintStream output = new PrintStream(this, "UTF-8");
        output.println("<puntuaciones>");
        output.println("</puntuaciones>");
        output.close();
    }
    
}