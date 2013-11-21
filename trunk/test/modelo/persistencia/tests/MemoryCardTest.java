package persistencia.tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import persistencia.MemoryCard;
import persistencia.TablaDePuntuaciones;

public class MemoryCardTest {

	private File archivoPuntuaciones;
	
	@Rule
	public TemporaryFolder temp = new TemporaryFolder();
	
	@Before
	public void setUp() throws IOException {
		archivoPuntuaciones = temp.newFile("puntuaciones.xml");
		setPuntuaciones();
	}
	
	private void setPuntuaciones() throws IOException {
		PrintWriter writer = new PrintWriter(archivoPuntuaciones, "UTF-8");
		writer.println("<puntuaciones>");
		writer.println("<jugador nombre=\"Fulano\" puntuacion=\"8\" />");
		writer.println("<jugador nombre=\"Mengano\" puntuacion=\"12\" />");
		writer.println("<jugador nombre=\"Pepito\" puntuacion=\"16\" />");
		writer.println("</puntuaciones>");
		writer.close();
	}
	
	@Test
	public void test_archivoTemporalDePuntuacionesPreparadoCorrectamente() throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoPuntuaciones));
		assertEquals(lector.readLine(), "<puntuaciones>");
		assertEquals(lector.readLine(), "<jugador nombre=\"Fulano\" puntuacion=\"8\" />");
		assertEquals(lector.readLine(), "<jugador nombre=\"Mengano\" puntuacion=\"12\" />");
		assertEquals(lector.readLine(), "<jugador nombre=\"Pepito\" puntuacion=\"16\" />");
		assertEquals(lector.readLine(), "</puntuaciones>");
		lector.close();
	}
	
	@Test
	public void test_puntuacionesCargadasCorrectamente(){
		MemoryCard memory = new MemoryCard();
		TablaDePuntuaciones puntuaciones = memory.cargarPuntuaciones(archivoPuntuaciones);
		
		assertEquals(puntuaciones.entradaEnPosicion(0).getNombre(), "Fulano");
		assertEquals(puntuaciones.entradaEnPosicion(1).getNombre(), "Mengano");
		assertEquals(puntuaciones.entradaEnPosicion(2).getNombre(), "Pepito");
		
		assertEquals(puntuaciones.entradaEnPosicion(0).getPuntuacion(), 8);
		assertEquals(puntuaciones.entradaEnPosicion(1).getPuntuacion(), 12);
		assertEquals(puntuaciones.entradaEnPosicion(2).getPuntuacion(), 16);
	}
	
	@Test
	public void test_nuevasPuntuacionesSonIngresadasCorrectamente(){
		MemoryCard memory = new MemoryCard();
		memory.nuevaPuntuacion(archivoPuntuaciones, "Juancito", 14);
		
		TablaDePuntuaciones puntuaciones = memory.cargarPuntuaciones(archivoPuntuaciones);
		assertEquals(puntuaciones.entradaEnPosicion(2).getNombre(), "Juancito");
		assertEquals(puntuaciones.entradaEnPosicion(2).getPuntuacion(), 14);
	}
	
	@Test
	public void test_jugadoresYaExistentesSonActualizados(){
        MemoryCard memory = new MemoryCard();
        memory.nuevaPuntuacion(archivoPuntuaciones, "Mengano", 7);
        
        TablaDePuntuaciones puntuaciones = memory.cargarPuntuaciones(archivoPuntuaciones);
        assertEquals(puntuaciones.entradaEnPosicion(0).getNombre(), "Mengano");
        assertEquals(puntuaciones.entradaEnPosicion(0).getPuntuacion(), 7);
        assertEquals(puntuaciones.entradaEnPosicion(1).getNombre(), "Fulano");
        assertEquals(puntuaciones.entradaEnPosicion(1).getPuntuacion(), 8);
        assertEquals(puntuaciones.entradaEnPosicion(2).getNombre(), "Pepito");
        assertEquals(puntuaciones.entradaEnPosicion(2).getPuntuacion(), 16);
        assertEquals(puntuaciones.getCantidadDePuntuaciones(), 3);
	}

}
