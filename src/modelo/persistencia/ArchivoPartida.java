package modelo.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class ArchivoPartida extends File {
    
    private static final long serialVersionUID = 1L;

    public ArchivoPartida(String nombre) throws IOException {
        super("data/" + nombre + ".xml");
        crearArchivoSiNoExisteYa();
    }

    public void crearArchivoSiNoExisteYa() throws IOException{
        if(createNewFile())
            ingresarRootXML();
    }
    
    private void ingresarRootXML() throws IOException {
        PrintStream output = new PrintStream(this, "UTF-8");
        output.println("<partida>");
        output.println("</partida>");
        output.close();
    }

}
