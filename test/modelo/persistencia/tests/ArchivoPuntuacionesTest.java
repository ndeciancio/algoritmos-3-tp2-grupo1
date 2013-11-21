package modelo.persistencia.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import modelo.persistencia.ArchivoPuntuaciones;

import org.junit.Test;

public class ArchivoPuntuacionesTest {

    @Test
    public void test_archivoPuntuacionesDeberiaCrearseAutomaticamenteDeNoExistir() throws IOException {
        File archivo = new ArchivoPuntuaciones();
        assertTrue(archivo.exists());
    }

}
